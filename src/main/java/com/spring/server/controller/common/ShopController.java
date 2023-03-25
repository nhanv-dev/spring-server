package com.spring.server.controller.common;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.User;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.ProductService;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getByShopId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(shopService.findOneById(id));
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> getProductsByShopId(
            Authentication authentication,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        ShopDto shop = shopService.findOneByUserId(user.getId());
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> products = productService.findByShopId(pageable, shop.getId());
        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> createProduct(Authentication authentication, @RequestBody ProductDto productDto) {
        User user = userService.findOneByEmail(authentication.getName());
        ShopDto shop = shopService.findOneByUserId(user.getId());
        productDto.setShop(shop);
        ProductDto product = productService.save(productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Deleted product with id " + id));
    }

}

