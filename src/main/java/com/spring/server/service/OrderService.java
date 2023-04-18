package com.spring.server.service;


import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;


public interface OrderService {
    OrderDto findOneById(Long id);

    Page<OrderDto> findByShopId(Pageable pageable, Long shopId);

    Set<OrderDto> findAllByUserId(Long userId);

    Set<OrderDto> placeOrder(Set<OrderDto> orderDtos);

    Set<OrderStatusDto> findAllStatus();

    OrderStatusDto findStatusByType(EOrderStatus type);

    OrderDto save(OrderDto orderDto);

    OrderDto updateStatus(Long orderId, EOrderStatus status);

}
