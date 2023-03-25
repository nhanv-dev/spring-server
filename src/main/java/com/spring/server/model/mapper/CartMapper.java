package com.spring.server.model.mapper;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class CartMapper {
    public static CartDto toDto(Cart cart) {
        CartDto result = new CartDto();
        result.setId(cart.getId());
        result.setUserId(cart.getUser().getId());
        result.setItems(CartItemMapper.toDtos(cart.getItems()));
        result.setShop(ShopMinimalMapper.toDto(cart.getShop()));
        return result;
    }

    public static Set<CartDto> toDtos(Set<Cart> carts) {
        if (carts == null || carts.isEmpty()) return null;
        Set<CartDto> result = new TreeSet<>();
        for (Cart cart : carts) result.add(toDto(cart));
        return result;
    }

    public static Cart toEntity(CartDto cart) {
        Cart result = new Cart();
        result.setId(cart.getId());
        result.setItems(CartItemMapper.toEntities(cart.getItems()));
        return result;
    }
}
