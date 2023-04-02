package com.spring.server.model.mapper;

import com.spring.server.model.dto.OrderStatusDto;
import com.spring.server.model.entity.OrderStatus;

public class OrderStatusMapper {

    public static OrderStatusDto toDto(OrderStatus orderStatus) {
        OrderStatusDto result = new OrderStatusDto();
        result.setId(orderStatus.getId());
        result.setStatus(orderStatus.getStatus());
        result.setDescription(orderStatus.getDescription());
        return result;
    }

    public static OrderStatus toEntity(OrderStatusDto orderStatusDto) {
        OrderStatus result = new OrderStatus();
        result.setId(orderStatusDto.getId());
        result.setStatus(orderStatusDto.getStatus());
        result.setDescription(orderStatusDto.getDescription());
        return result;
    }

}
