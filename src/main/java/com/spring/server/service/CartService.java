package com.spring.server.service;


import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.entity.User;

import java.util.Set;


public interface CartService {
    Set<CartDto> findAllByUserId(Long userId);

    CartDto findByUserIdAndShopId(Long userId, Long shopId);

    CartDto save(CartDto cartDto);

    CartItemDto saveCartItem(User user, CartItemDto cartItemDto);

    void removeCartItem(Long id);
}
