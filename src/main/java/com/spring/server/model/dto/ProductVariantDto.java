package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantDto {
    private Long id;
    private String attributeHash, skuUser;
    private Double price;
    private int quantity;
    private boolean isDeleted;
    private Set<ProductAttributeOptionDto> options;
}
