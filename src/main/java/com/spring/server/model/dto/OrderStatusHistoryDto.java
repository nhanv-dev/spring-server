package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusHistoryDto implements Comparable<OrderStatusHistoryDto> {
    private Long id;
    private OrderStatusDto orderStatus;
    private Date createdAt, updatedAt;

    @Override
    public int compareTo(OrderStatusHistoryDto o) {
        return id.compareTo(o.getId());
    }
}
