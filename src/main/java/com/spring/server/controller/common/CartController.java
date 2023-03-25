package com.spring.server.controller.common;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.entity.User;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getCartByUserId(Authentication authentication) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have permission to access");
        Set<CartDto> cart = cartService.findAllByUserId(user.getId());
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/items")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> addCartItem(Authentication authentication, @RequestBody CartItemDto cartItemDto) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have user");
        CartItemDto item = cartService.saveCartItem(user, cartItemDto);
        return ResponseEntity.ok(new MessageResponse("Added cart item", item));
    }

    @DeleteMapping("/items/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> removeCartItem(Authentication authentication, @PathVariable Long id) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || user.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have user");
        cartService.removeCartItem(id);
        return ResponseEntity.ok(new MessageResponse("Removed cart item"));
    }
}

