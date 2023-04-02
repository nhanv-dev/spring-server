package com.spring.server.service.implement;

import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.Order;
import com.spring.server.model.entity.OrderStatus;
import com.spring.server.model.mapper.OrderMapper;
import com.spring.server.model.mapper.OrderStatusMapper;
import com.spring.server.repository.CartItemRepo;
import com.spring.server.repository.OrderItemRepo;
import com.spring.server.repository.OrderRepo;
import com.spring.server.repository.OrderStatusRepo;
import com.spring.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @Override
    public Set<OrderDto> findAllByUserId(Long userId) {
        List<Order> orders = orderRepo.findAllByUser_Id(userId);
        return OrderMapper.toDtos(orders);
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        order = orderRepo.save(order);
        return OrderMapper.toDto(order);
    }

    @Override
    @Transactional
    public Set<OrderDto> placeOrder(Set<OrderDto> orderDtos) {
        Set<Order> orders = OrderMapper.toEntities(orderDtos);
        List<Order> savedOrders = orderRepo.saveAll(orders);
        orderDtos.forEach(orderDto -> {
            orderDto.getItems().forEach(item -> {
                cartItemRepo.deleteById(item.getCartItemId());
            });
        });
        return OrderMapper.toDtos(savedOrders);
    }

    @Override
    public OrderStatusDto findStatusByType(EOrderStatus type) {
        OrderStatus status = orderStatusRepo.findOneByStatus(type);
        return OrderStatusMapper.toDto(status);
    }

    @Override
    public void updateStatus(OrderDto orderDto) {

    }
}
