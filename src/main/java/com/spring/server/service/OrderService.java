package com.spring.server.service;


import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.*;
import com.spring.server.model.entity.CancelledOrder;
import com.spring.server.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;


public interface OrderService {
    OrderDto findOneById(Long id);

    Page<OrderDto> findByShopId(Pageable pageable, Long shopId);

    Page<OrderDto> findAllByUserId(int page, int size, Long userId);

    Page<OrderDto> findAllByUserIdAndStatusId(int page, int size, Long userId, Long statusId);

    OrderDto save(OrderDto orderDto);

    OrderDto updateStatus(Long orderId, EOrderStatus status);

    Set<OrderDto> placeOrder(Set<OrderDto> orderDtos);

    void cancelOrder(CancelledOrderDto cancelledOrderDto);

    CancelledOrderDto findCancelledOrderByOrderId(Long orderId);

    Set<OrderStatusDto> findAllStatus();

    OrderStatusDto findStatusByType(EOrderStatus type);


}
