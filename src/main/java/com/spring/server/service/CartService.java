package com.spring.server.service;


import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;


public interface CartService {
    Set<CartDto> findAllByUserId(Long userId);

    CartDto findByUserIdAndShopId(Long userId, Long shopId);

    void addCartItem(User user, Shop shop, CartItemDto cartItemDto);

    CartDto save(CartDto cartDto);
}
