package com.spring.server.controller;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ProductReviewsDto;
import com.spring.server.model.entity.User;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ReviewsService reviewsService;
    @Autowired
    ReturnPolicyService returnPolicyService;
    @Autowired
    UserRepo userRepo;


    @GetMapping("")
    public ResponseEntity<?> getProducts(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "30") Integer size
    ) {
        Page<ProductDto> products = productService.findByOrderByCreatedAt(page, size);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categorySlug}")
    public ResponseEntity<?> getProductsByCategory(
            @PathVariable String categorySlug,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "30") Integer size
    ) {
        Page<ProductDto> products = productService.findByCategorySlug(page, size, categorySlug);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/shops/{shopId}")
    public ResponseEntity<?> getProductsByShopId(
            @PathVariable Long shopId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "30") Integer size
    ) {
        Page<ProductDto> product = productService.findByShopId(page, size, shopId, true, false);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/shops/{shopId}/top/{top}")
    public ResponseEntity<?> getTopProductsByShopId(
            @PathVariable Long shopId,
            @PathVariable Integer top,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "30") Integer size
    ) {
        Page<ProductDto> list = productService.findByShopId(page, size, shopId, true, false);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        ProductDto product = productService.findOneById(id);
        if (product == null || product.getId() == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}/evaluates")
    public ResponseEntity<?> getEvaluateProductById(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        Page<ProductReviewsDto> productReviewsDtos = reviewsService.findProductReviewsByProductId(page, size, id);
        return ResponseEntity.ok(productReviewsDtos);
    }

    @PostMapping("/{id}/evaluates")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> evaluateProductById(Authentication authentication, @PathVariable Long id, @Valid @RequestBody ProductReviewsDto productReviews) {
        User user = userRepo.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        productReviews.setUserId(user.getId());
        reviewsService.evaluateProduct(productReviews);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getProductBySlug(@PathVariable String slug) {
        ProductDto product = productService.findOneBySlug(slug);
        if (product == null || product.getId() == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/return-policy")
    public ResponseEntity<?> getReturnPolicyProduct() {
        return ResponseEntity.ok(returnPolicyService.findAll());
    }
}

