package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemDto implements Comparable<CartItemDto> {
    private Long id, productId, variantId, shopId;
    private ProductDto product;
    private ProductVariantDto variant;
    private Integer quantity;

    @Override
    public int compareTo(CartItemDto o) {
        return id.compareTo(o.getId());
    }
}
