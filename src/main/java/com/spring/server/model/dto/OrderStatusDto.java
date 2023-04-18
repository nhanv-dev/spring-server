package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.constant.EOrderStatus;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusDto implements Comparable<OrderStatusDto> {
    private Long id;
    private EOrderStatus status;
    private String title;
    private String description;
    private String labelConfirm;
    private String labelCreatedAt;

    @Override
    public int compareTo(OrderStatusDto o) {
        return id.compareTo(o.getId());
    }
}
