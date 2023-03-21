package com.spring.server.model.mapper;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMinimalMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setPrice(product.getPrice());

        result.setRatingInfo(RatingInfoMapper.toDto(product.getRatingInfo()));
        result.setDiscount(DiscountMapper.toDtoWithRunning(product.getDiscounts()));
        result.setImages(ProductImageMapper.toDto(product.getImages()));

        return result;
    }

}
