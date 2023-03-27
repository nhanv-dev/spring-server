package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.entity.Product;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto implements Comparable<CartDto> {
    private Long id;
    private Long userId;
    private Set<CartItemDto> items;
    @Override
    public int compareTo(CartDto o) {
        return id.compareTo(o.getId());
    }
}
