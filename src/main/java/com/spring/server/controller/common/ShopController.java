package com.spring.server.controller.common;


import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.User;
import com.spring.server.payload.request.StatusOrderRequest;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.OrderService;
import com.spring.server.service.ProductService;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    UserService userService;
    @Autowired
    ShopService shopService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getShopByShopId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(shopService.findOneById(id));
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> getShopByUserId(Authentication authentication, @PathVariable(value = "id") Long id) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.ok(shopService.findOneByUserId(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> updateProfile(@PathVariable("id") Long id, @RequestBody ShopDto shopDto, Authentication authentication) {
        User user = userService.findOneByEmail(authentication.getName());
        if (!Objects.equals(user.getShop().getId(), id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Shop saved failed"));
        shopDto.setUserId(user.getId());
        shopDto = shopService.update(shopDto);
        return ResponseEntity.ok(shopDto);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getShopByShopSlug(@PathVariable(value = "slug") String slug) {
        return ResponseEntity.ok(shopService.findOneBySlug(slug));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(Authentication authentication, @PathVariable Long id) {
        ProductDto product = productService.findOneById(id, null, false);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> getProductsByShopId(
            Authentication authentication,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        ShopDto shop = shopService.findOneByUserId(user.getId());
        Page<ProductDto> products = productService.findByShopId(page, limit, shop.getId(), null, false);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> saveProduct(Authentication authentication, @RequestBody ProductDto productDto) {
        User user = userService.findOneByEmail(authentication.getName());
        ShopDto shop = shopService.findOneByUserId(user.getId());
        productDto.setShop(shop);
        if (productDto.getIsPublic() == null)
            productDto.setIsPublic(true);
        if (productDto.getIsDeleted() == null)
            productDto.setIsDeleted(false);
        ProductDto product = productService.save(productDto);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> updateProduct(Authentication authentication, @PathVariable(value = "id") Long id, @RequestBody ProductDto productDto) {
        User user = userService.findOneByEmail(authentication.getName());
        ShopDto shop = shopService.findOneByUserId(user.getId());
        productDto.setShop(shop);
        ProductDto product = productService.update(productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Deleted product with id " + id));
    }

    @GetMapping("/orders")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> getOrdersByShopId(
            Authentication authentication,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        ShopDto shop = shopService.findOneByUserId(user.getId());
        Pageable pageable = PageRequest.of(page, limit, Sort.by("updatedAt").descending());
        Page<OrderDto> orders = orderService.findByShopId(pageable, shop.getId());
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/{orderId}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.findOneById(orderId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/orders/{orderId}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> updateOrder(
            @PathVariable Long orderId,
            @Valid @RequestBody StatusOrderRequest request
    ) {
        if (!Objects.equals(orderId, request.getOrderId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        OrderDto order = orderService.updateStatus(request.getOrderId(), request.getStatus());
        return ResponseEntity.ok(order);
    }
}

