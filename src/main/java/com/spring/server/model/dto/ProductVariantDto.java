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
public class ProductVariantDto implements Comparable<ProductVariantDto> {
    private Long id;
    private String attributeHash;
    private DealDto deal;
    private int quantity;
    private boolean isDeleted;
    private Set<ProductAttributeOptionDto> options;
    @Override
    public int compareTo(ProductVariantDto o) {
        return this.getId().compareTo(o.getId());
    }
}
