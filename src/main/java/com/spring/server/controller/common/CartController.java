package com.spring.server.controller.common;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.User;
import com.spring.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getCartByUserId(Authentication authentication, @PathVariable Long userId) {
        User user = userService.findOneByEmail(authentication.getName());
        if (!Objects.equals(user.getId(), userId))
            return ResponseEntity.status(403).body("You do not have permission to access");
        Set<CartDto> cart = cartService.findAllByUserId(userId);
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/items")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> addCartItem(Authentication authentication, @RequestBody CartItemDto cartItemDto) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null)
            return ResponseEntity.status(403).body("You do not have permission to access");
        ;
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }
}

