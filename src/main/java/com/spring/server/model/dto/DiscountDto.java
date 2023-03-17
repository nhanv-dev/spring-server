package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscountDto extends BaseDto {
    private Double price, finalPrice, discountPercent;

    private Boolean isRunning, isDeleted;
}
