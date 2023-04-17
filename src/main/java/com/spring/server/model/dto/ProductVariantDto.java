package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    private Boolean isDeleted;
    private Set<ProductAttributeOptionDto> options;

    @Override
    public int compareTo(ProductVariantDto productVariant) {
        if (options == null || options.isEmpty() || productVariant.getOptions() == null || productVariant.getOptions().isEmpty())
            return id.compareTo(productVariant.getId());
        String str1 = "", str2 = "";
        for (ProductAttributeOptionDto o1 : options)
            str1 += o1.getName();
        for (ProductAttributeOptionDto o1 : productVariant.getOptions())
            str2 += o1.getName();
        return str1.compareTo(str2);
    }
}
