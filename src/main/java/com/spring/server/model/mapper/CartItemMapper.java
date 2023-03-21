package com.spring.server.model.mapper;

import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class CartItemMapper {
    public static CartItemDto toDto(CartItem cartItem) {
        CartItemDto result = new CartItemDto();
        result.setId(cartItem.getId());
        result.setQuantity(cartItem.getQuantity());
        result.setProduct(ProductMinimalMapper.toDto(cartItem.getProduct()));
        return result;
    }

    public static Set<CartItemDto> toDtos(Set<CartItem> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) return null;
        Set<CartItemDto> result = new TreeSet<>();
        for (CartItem item : cartItems) {
            result.add(toDto(item));
        }
        return result;
    }

    public static CartItem toEntity(CartItemDto cartItem) {
        CartItem result = new CartItem();
        result.setId(cartItem.getId());
        result.setQuantity(cartItem.getQuantity());
        result.setProduct(ProductMapper.toEntity(cartItem.getProduct()));
        return result;
    }

    public static Set<CartItem> toEntities(Set<CartItemDto> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) return null;
        Set<CartItem> result = new HashSet<>();
        for (CartItemDto item : cartItems) {
            result.add(toEntity(item));
        }
        return result;
    }
}
