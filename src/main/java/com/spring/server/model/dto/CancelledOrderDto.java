package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.entity.Order;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelledOrderDto {
    private Long id, orderId;
    private OrderDto order;
    private String note;
    private Date createdAt, updatedAt;
}
