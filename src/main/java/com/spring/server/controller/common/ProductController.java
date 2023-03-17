package com.spring.server.controller.common;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.User;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.service.ProductService;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(required = false, defaultValue = "1") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 60);
        Page<ProductDto> products = productService.findByOrderByCreatedAt(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getProductBySlug(@PathVariable String slug) {
        ProductDto product = productService.findOneBySlug(slug);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<?> getProductByCategoryUrl(@PathVariable(value = "categorySlug") String slug) {
        return ResponseEntity.ok(slug);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
        ProductDto product = productService.findOneById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> createProduct(Authentication authentication, @RequestBody ProductDto productDto) {
        User user = userService.findOneByEmail(authentication.getName());
        ShopDto shop = shopService.findOneByUserId(user.getId());
        productDto.setShop(shop);
        System.out.println(productDto);
        ProductDto product = productService.save(productDto);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
}

