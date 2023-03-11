package com.spring.server.controller.common;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Product;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(required = false, defaultValue = "1") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 60);
        Page<Product> products=productService.findByOrderByCreatedAt(pageable);
        return ResponseEntity.ok(ProductMapper.toDto(products));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getProductBySlug(@PathVariable String slug) {
        Product product = productService.findOneBySlug(slug);
        return ResponseEntity.ok(ProductDetailMapper.toDto(product));
    }

    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<?> getProductByCategoryUrl(@PathVariable(value = "categorySlug") String slug) {
        return ResponseEntity.ok(slug);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long id) {
        Product product = productService.findOneById(id);
        return ResponseEntity.ok(ProductDetailMapper.toDto(product));
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct() {
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
}

