package com.spring.server.model.mapper;

import com.spring.server.entity.Product;
import com.spring.server.entity.Role;
import com.spring.server.entity.User;
import com.spring.server.model.dto.*;

import java.util.ArrayList;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = new ProductDto();
        CategoryDto category = new CategoryDto(product.getCategory().getTitle(), product.getCategory().getSlug(), product.getCategory().getIcon(), null);
        SubCategoryDto subCategory = new SubCategoryDto(product.getCategory().getTitle(), product.getCategory().getSlug(), product.getCategory().getIcon());
        category.setId(product.getCategory().getId());
        subCategory.setId(product.getSubCategory().getId());

        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setId(product.getId());
        result.setCategory(category);
        result.setOrderCount(product.getOrderCount());
        result.setSubCategory(subCategory);
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());
        return result;
    }


}
