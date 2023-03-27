package com.spring.server.service.implement;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.entity.*;
import com.spring.server.model.mapper.CartItemMapper;
import com.spring.server.model.mapper.CartMapper;
import com.spring.server.repository.*;
import com.spring.server.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductVariantRepo productVariantRepo;

    @Override
    public CartDto findOneByUserId(Long userId) {
        Cart cart = cartRepo.findOneByUser_Id(userId);
        return CartMapper.toDto(cart);
    }

    @Override
    public CartDto findByUserIdAndShopId(Long userId, Long shopId) {
        return null;
    }

    @Override
    @Transactional
    public CartDto save(CartDto cartDto) {
//        Cart savedCart = cartRepo.findOneByUser_Id(cartDto.getUserId());
//        System.out.println(CartMapper.toDto(savedCart));
//        Cart cart = CartMapper.toEntity(cartDto);
        return null;
    }

    @Override
    @Transactional
    public CartItemDto saveCartItem(User user, CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        Product product = productRepo.findOneByIdAndIsPublic(cartItemDto.getProductId(), true);
        ProductVariant productVariant = productVariantRepo.findOneByIdAndProduct_Id(cartItemDto.getVariantId(), cartItemDto.getProductId());
        Cart cart = cartRepo.findOneByUser_Id(user.getId());
        if (cart == null) cart = cartRepo.save(new Cart(user, new HashSet<>()));
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setProduct(product);
        cartItem.setVariant(productVariant);
        cartItem.setCart(cart);
        if (cart.containItem(cartItem)) cartItem = cart.updateItem(cartItem);
        else cartItem = cartItemRepo.save(cartItem);
        cartRepo.save(cart);
        return CartItemMapper.toDto(cartItem);
    }

    @Override
    @Transactional
    public void updateCartItem(CartItemDto cartItemDto) {
        cartItemRepo.updateQuantity(cartItemDto.getId(), cartItemDto.getQuantity());
    }

    @Override
    @Transactional
    public void removeCartItem(Long id) {
        cartItemRepo.deleteById(id);
    }

}
