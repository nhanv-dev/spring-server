package com.spring.server.controller.common;


import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.entity.User;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.security.jwt.JwtUtils;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;

import com.spring.server.util.SlugGenerator;
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

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public ResponseEntity<?> getByShopId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(shopService.findOneById(id));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getByShopSlug(@PathVariable(value = "slug") String slug) {
        return ResponseEntity.ok(shopService.findOneBySlug(slug));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        ProductDto product = shopService.findProductById(id);
        return ResponseEntity.ok(product);
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
        System.out.println(shop.getId());
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("updatedAt").descending());
        Page<ProductDto> products = shopService.findProductByShopId(pageable, shop.getId());
        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> createProduct(Authentication authentication, @RequestBody ProductDto productDto) {
        User user = userService.findOneByEmail(authentication.getName());
        ShopDto shop = shopService.findOneByUserId(user.getId());
        productDto.setShop(shop);
        if (productDto.getIsPublic() == null)
            productDto.setIsPublic(true);
        if (productDto.getIsDeleted() == null)
            productDto.setIsDeleted(false);
        ProductDto product = shopService.saveProduct(productDto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        shopService.deleteProduct(id);
        return ResponseEntity.ok(new MessageResponse("Deleted product with id " + id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")

    public ResponseEntity<?> updateUser(@PathVariable( "id") Long id, @RequestBody ShopDto shopDto, Authentication authentication){
        User user = userService.findOneByEmail(authentication.getName());
        Shop currentShop = shopService.findById(id);
       if(user.getShop().getId()!= id )
           return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Update Fail"));

        currentShop.setShopName(shopDto.getShopName());
        currentShop.setEmail(shopDto.getShopEmail());
        currentShop.setPhoneNumber(shopDto.getShopPhone());
        currentShop.setSlug(SlugGenerator.toSlug(currentShop.getShopName() + "-" + currentShop.getId()));
        currentShop.setShopSlogan(shopDto.getShopSlogan());
        currentShop.setShopLogo(shopDto.getShopLogo());
        currentShop.setShopBackground(shopDto.getShopBackground());

        shopService.updateShop(currentShop);

        return ResponseEntity.ok(new MessageResponse("User saved successfully!!"));
    }

}

