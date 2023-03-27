package com.spring.server.controller.common;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.User;
import com.spring.server.service.ProductService;
import com.spring.server.service.ReturnPolicyService;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ReturnPolicyService returnPolicyService;

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(required = false, defaultValue = "1") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 30);
        Page<ProductDto> products = productService.findByOrderByCreatedAt(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable String categorySlug, @RequestParam(required = false, defaultValue = "1") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 30);
        Page<ProductDto> products = productService.findByCategorySlug(pageable, categorySlug);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        ProductDto product = productService.findOneById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<?> getProductsByShopId(@PathVariable Long shopId, @RequestParam(required = false, defaultValue = "1") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 30);
        Page<ProductDto> product = productService.findByShopId(pageable, shopId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shop/{shopId}/top/{top}")
    public ResponseEntity<?> getTopProductsByShopId(@PathVariable Long shopId, @PathVariable Integer top) {
        Pageable pageable = PageRequest.of(0, top);
        Page<ProductDto> list = productService.findByShopId(pageable, shopId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getProductBySlug(@PathVariable String slug) {
        ProductDto product = productService.findOneBySlug(slug);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/return-policy")
    public ResponseEntity<?> getReturnPolicyProduct() {
        return ResponseEntity.ok(returnPolicyService.findAll());
    }
}

