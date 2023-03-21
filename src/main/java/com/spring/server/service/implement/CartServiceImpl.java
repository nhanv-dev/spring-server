package com.spring.server.service.implement;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.entity.Cart;
import com.spring.server.model.entity.CartItem;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.entity.User;
import com.spring.server.model.mapper.CartItemMapper;
import com.spring.server.model.mapper.CartMapper;
import com.spring.server.repository.CartItemRepo;
import com.spring.server.repository.CartRepo;
import com.spring.server.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemRepo cartItemRepo;

    @Override
    public Set<CartDto> findAllByUserId(Long userId) {
        Set<Cart> carts = cartRepo.findAllByUser_Id(userId);
        return CartMapper.toDtos(carts);
    }

    @Override
    public CartDto findByUserIdAndShopId(Long userId, Long shopId) {
        return null;
    }

    @Override
    @Transactional
    public void addCartItem(User user, Shop shop, CartItemDto cartItemDto) {
        CartItem cartItem = CartItemMapper.toEntity(cartItemDto);
        Cart cart = cartRepo.findOneByUser_IdAndShop_Id(user.getId(), shop.getId());
        if (cart == null) {
            Set<CartItem> items = new HashSet<>();
            items.add(cartItem);
            cartRepo.save(new Cart(user, shop, items));
            return;
        }
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(cartItem.getProduct().getId())) {
                item.setQuantity(cartItem.getQuantity());
                cartRepo.save(cart);
                return;
            }
        }
        cart.getItems().add(cartItem);
        cartRepo.save(cart);
    }

    @Override
    public CartDto save(CartDto cartDto) {
//        Cart savedCart = cartRepo.findOneByUser_Id(cartDto.getUserId());
//        System.out.println(CartMapper.toDto(savedCart));
//        Cart cart = CartMapper.toEntity(cartDto);
        return null;
    }
}
