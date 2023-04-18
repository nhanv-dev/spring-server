package com.spring.server.model.mapper;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ProductReviewsDto;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductReviews;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductReviewsMapper {
    public static ProductReviewsDto toDto(ProductReviews productReviews) {
        ProductReviewsDto result = new ProductReviewsDto();
        result.setId(productReviews.getId());
        result.setUser(UserMapper.toDto(productReviews.getUser()));
        result.setContent(productReviews.getContent());
        result.setRating(productReviews.getRating());
        result.setCreatedAt(productReviews.getCreatedAt());
        return result;
    }

    public static Page<ProductReviewsDto> toDto(Page<ProductReviews> productReviews) {
        return productReviews.map(new Function<ProductReviews, ProductReviewsDto>() {
            @Override
            public ProductReviewsDto apply(ProductReviews productReview) {
                return toDto(productReview);
            }
        });
    }


}
