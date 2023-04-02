package com.spring.server.model.mapper;

import com.spring.server.model.dto.OrderDto;
import com.spring.server.model.entity.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMapper {

    public static OrderDto toDto(Order order) {
        OrderDto result = new OrderDto();
        result.setId(order.getId());
        result.setShopId(order.getShop().getId());
        result.setShop(ShopMinimalMapper.toDto(order.getShop()));
        result.setOrderStatus(OrderStatusMapper.toDto(order.getOrderStatus()));
        result.setItems(OrderItemMapper.toDtos(order.getItems()));
        result.setNote(order.getNote());
        result.setTotalPrice(order.getTotalPrice());
        result.setCreatedAt(order.getCreatedAt());
        result.setUpdatedAt(order.getUpdatedAt());
        return result;
    }

    public static Set<OrderDto> toDtos(List<Order> orders) {
        if (orders == null) return null;
        Set<OrderDto> result = new HashSet<>();
        for (Order order : orders) {
            result.add(toDto(order));
        }
        return result;
    }

    public static Order toEntity(OrderDto order) {
        Order result = new Order();
        result.setId(order.getId());
        result.setTotalPrice(order.getTotalPrice());
        result.setOrderStatus(OrderStatusMapper.toEntity(order.getOrderStatus()));
        result.setUserAddress(UserAddressMapper.toEntity(order.getAddress()));
        result.setItems(OrderItemMapper.toEntities(order.getItems(), result));
        result.setShop(ShopMapper.toEntity(order.getShop()));
        result.setUser(UserMapper.toEntity(order.getUser()));
        result.setNote(order.getNote());
        return result;
    }

    public static Set<Order> toEntities(Set<OrderDto> orders) {
        if (orders == null) return null;
        Set<Order> result = new HashSet<>();
        for (OrderDto order : orders) {
            result.add(toEntity(order));
        }
        return result;
    }
}
