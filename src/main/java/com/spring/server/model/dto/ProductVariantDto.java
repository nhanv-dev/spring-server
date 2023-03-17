package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariantDto {
    private Long id;
    private String attributeHash, skuUser;
    private Double price;
    private int quantity;
    private boolean isDeleted;
    private Set<ProductAttributeOptionDto> options;
}
