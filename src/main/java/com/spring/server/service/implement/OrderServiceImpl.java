package com.spring.server.service.implement;

import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.Order;
import com.spring.server.model.entity.OrderStatus;
import com.spring.server.model.entity.OrderStatusHistory;
import com.spring.server.model.mapper.OrderMapper;
import com.spring.server.model.mapper.OrderStatusMapper;
import com.spring.server.repository.*;
import com.spring.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private OrderStatusRepo orderStatusRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public OrderDto findOneById(Long id) {
        Order order = orderRepo.findOneById(id);
        return OrderMapper.toDto(order);
    }

    @Override
    public Page<OrderDto> findByShopId(Pageable pageable, Long shopId) {
        return OrderMapper.toDto(orderRepo.findAllByShop_Id(pageable, shopId));
    }

    @Override
    public Set<OrderDto> findAllByUserId(Long userId) {
        List<Order> orders = orderRepo.findAllByUser_Id(userId);
        return OrderMapper.toDto(orders);
    }

    @Override
    public Set<OrderStatusDto> findAllStatus() {
        return OrderStatusMapper.toDto(new HashSet<>(orderStatusRepo.findAll()));
    }

    @Override
    public OrderStatusDto findStatusByType(EOrderStatus type) {
        OrderStatus status = orderStatusRepo.findOneByStatus(type);
        return OrderStatusMapper.toDto(status);
    }

    @Override
    @Transactional
    public OrderDto save(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        order = orderRepo.save(order);
        return OrderMapper.toDto(order);
    }

    @Override
    @Transactional
    public Set<OrderDto> placeOrder(Set<OrderDto> orderDtos) {
        Set<Order> orders = OrderMapper.toEntities(orderDtos);
        OrderStatus pendingStatus = orderStatusRepo.findOneByStatus(EOrderStatus.PENDING);
        orders.forEach(order -> {
            OrderStatusHistory history = new OrderStatusHistory();
            history.setOrder(order);
            history.setOrderStatus(pendingStatus);
            order.addHistory(history);
        });
        List<Order> savedOrders = orderRepo.saveAll(orders);
        orderDtos.forEach(orderDto -> {
            orderDto.getItems().forEach(item -> {
                cartItemRepo.deleteById(item.getCartItemId());
                productRepo.increaseOrderCount(item.getProduct().getId(), item.getQuantity());
            });
        });
        return OrderMapper.toDto(savedOrders);
    }


    @Override
    @Transactional
    public OrderDto updateStatus(Long orderId, EOrderStatus status) {
        Order order = orderRepo.findOneById(orderId);
        OrderStatus orderStatus = orderStatusRepo.findOneByStatus(status);
        order.setOrderStatus(orderStatus);
        OrderStatusHistory history = new OrderStatusHistory(order, orderStatus);
        order.addHistory(history);
        order = orderRepo.save(order);
        return OrderMapper.toDto(order);
    }
}
