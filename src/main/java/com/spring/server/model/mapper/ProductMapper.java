package com.spring.server.model.mapper;

import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductImage;
import com.spring.server.model.dto.*;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setOrderCount(product.getOrderCount());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());

        result.setCategory(CategoryMapper.toDtoWithoutSub(product.getCategory()));
        result.setSubCategory(SubCategoryMapper.toDto(product.getSubCategory()));
        result.setRatingInfo(RatingInfoMapper.toDto(product.getRatingInfo()));

        Set<ProductImageDto> images = new HashSet<>();
        for (ProductImage image : product.getImages()) images.add(new ProductImageDto(image.getId(), image.getUrl()));
        result.setImages(images);

        return result;
    }

    public static Page<ProductDto> toDto(Page<Product> products) {
        return products.map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return ProductMapper.toDto(product);
            }
        });
    }
}
