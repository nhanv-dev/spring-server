package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductReviewsDto implements Comparable<ProductReviewsDto> {
    private Long id, userId, orderItemId, productId, variantId;
    private UserDto user;
    private ProductDto product;
    private ProductVariantDto variant;
    @NotBlank
    private String content;
    @NotBlank
    private Integer rating;
    private Date createdAt;

    @Override
    public int compareTo(ProductReviewsDto o) {
        return id.compareTo(o.getId());
    }
}
