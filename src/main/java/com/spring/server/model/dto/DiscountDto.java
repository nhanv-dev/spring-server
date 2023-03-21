package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscountDto implements Comparable<DiscountDto> {
    private Long id;
    private Double price, finalPrice, discountPercent;

    private Boolean isRunning, isDeleted;

    @Override
    public int compareTo(DiscountDto o) {
        return this.getId().compareTo(o.getId());
    }
}
