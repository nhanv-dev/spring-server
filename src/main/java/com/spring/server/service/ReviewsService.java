package com.spring.server.service;

import com.spring.server.model.constant.ERole;
import com.spring.server.model.dto.ProductReviewsDto;
import com.spring.server.model.entity.Role;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface ReviewsService {
    Page<ProductReviewsDto> findProductReviewsByUserId(int page, int size, Long userId);
    Page<ProductReviewsDto> findProductReviewsByProductId(int page, int size, Long productId);

    void evaluateProduct(ProductReviewsDto productReviews);

}
