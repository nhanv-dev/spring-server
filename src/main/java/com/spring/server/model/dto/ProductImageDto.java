package com.spring.server.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.entity.ProductImage;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductImageDto implements Comparable<ProductImageDto> {
    private Long id;
    private String url;
    @Override
    public int compareTo(ProductImageDto other) {
        return this.getId().compareTo(other.getId());
    }
}
