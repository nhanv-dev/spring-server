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
public class ProductDto extends BaseDto {
    private String name;
    private String slug;
    private String description;
    private String shortDescription;
    private String keywords;
    private Double price;
    private Integer quantity;
    private Integer orderCount;
    private CategoryDto category;
    private SubCategoryDto subCategory;
    private DiscountDto discount;
    private ShopDto shop;
    private RatingInfoDto ratingInfo;
    private Boolean isDeleted, isPublic;
    private Set<ReturnPolicyDto> returnPolicies;
    private Set<ProductImageDto> images;
    private Set<ProductAttributeDto> attributes;
    private Set<ProductVariantDto> variants;
    private Set<DiscountDto> discounts;

}
