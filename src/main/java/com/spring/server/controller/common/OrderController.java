package com.spring.server.controller.common;

import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.User;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.CartService;
import com.spring.server.service.OrderService;
import com.spring.server.service.ProductService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping("/users/{userId}/orders")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getOrdersByUserId(Authentication authentication, @PathVariable Long userId) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || !Objects.equals(user.getId(), userId))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have permission to access");
        Set<OrderDto> orderDtos = orderService.findAllByUserId(userId);
        return ResponseEntity.ok(orderDtos);
    }

    @PostMapping("/users/{userId}/orders/place-order")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> placeOrder(Authentication authentication, @PathVariable Long userId, @RequestBody Set<OrderDto> orders) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || !Objects.equals(user.getId(), userId))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have permission to access");
        OrderStatusDto status = orderService.findStatusByType(EOrderStatus.PENDING);
        orders.forEach(orderDto -> {
            orderDto.setOrderStatus(status);
            orderDto.setUser(UserMapper.toDto(user));
        });
        Set<OrderDto> orderDtos = orderService.placeOrder(orders);
        return ResponseEntity.ok(orderDtos);
    }

    @PutMapping("/users/{userId}/orders/{orderId}/cancel-order")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> cancelOrder(Authentication authentication, @PathVariable Long userId, @PathVariable Long orderId) {
        User user = userService.findOneByEmail(authentication.getName());
        if (user == null || !Objects.equals(user.getId(), userId))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Don't have permission to access");
        OrderStatusDto status = orderService.findStatusByType(EOrderStatus.CANCELLED);
        return ResponseEntity.ok(status);
    }


    @GetMapping("/order-status")
    public ResponseEntity<?> getOrderStatus() {
        Set<OrderStatusDto> status = orderService.findAllStatus();
        return ResponseEntity.ok(status);
    }
}

