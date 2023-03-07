package com.spring.server.controller.common;

import com.spring.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(required = false, defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 60);
        return ResponseEntity.ok(productService.findByOrderByCreatedAt(pageable));
    }


    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<?> getProductByCategoryUrl(@PathVariable(value = "categorySlug") String slug) {
        return ResponseEntity.ok(slug);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
    @PostMapping("")
    public ResponseEntity<?> createProduct(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
}

