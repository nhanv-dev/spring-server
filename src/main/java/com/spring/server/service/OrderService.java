package com.spring.server.service;


import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.CartItemDto;
import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.User;

import java.util.Set;


public interface OrderService {

    Set<OrderDto> findAllByUserId(Long userId);

    OrderDto save(OrderDto orderDto);

    Set<OrderDto> placeOrder(Set<OrderDto> orderDtos);

    OrderStatusDto findStatusByType(EOrderStatus type);

    void updateStatus(OrderDto orderDto);

}
