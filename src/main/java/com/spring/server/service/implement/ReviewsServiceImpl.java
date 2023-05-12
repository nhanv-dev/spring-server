package com.spring.server.service.implement;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ProductReviewsDto;
import com.spring.server.model.entity.*;
import com.spring.server.model.mapper.ProductReviewsMapper;
import com.spring.server.repository.*;
import com.spring.server.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
public class ReviewsServiceImpl implements ReviewsService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;
    @Autowired
    private ProductVariantRepo productVariantRepo;
    @Autowired
    private ProductReviewsRepo productReviewsRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Page<ProductReviewsDto> findProductReviewsByUserId(int page, int size, Long userId) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductReviews> list = productReviewsRepo.findByUser_Id(pageable, userId);
        return ProductReviewsMapper.toDto(list);
    }

    @Override
    public Page<ProductReviewsDto> findProductReviewsByProductId(int page, int size, Long productId) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductReviews> list = productReviewsRepo.findByProduct_Id(pageable, productId);
        return ProductReviewsMapper.toDto(list);
    }

    @Override
    @Transactional
    public void evaluateProduct(ProductReviewsDto productReviews) {
        ProductReviews reviews = new ProductReviews();
        if (productReviews.getVariantId() != null) {
            ProductVariant variant = productVariantRepo.findOneById(productReviews.getVariantId());
            reviews.setVariant(variant);
        }
        OrderItem orderItem = orderItemRepo.findOneById(productReviews.getOrderItemId());
        User user = userRepo.findOneById(productReviews.getUserId());
        Product product = productRepo.findOneById(productReviews.getProductId());
        RatingInfo ratingInfo = product.getRatingInfo();
        if (ratingInfo == null) ratingInfo = new RatingInfo();
        reviews.setProduct(product);
        reviews.setUser(user);
        reviews.setOrderItem(orderItem);
        reviews.setContent(productReviews.getContent());
        reviews.setRating(productReviews.getRating());
        productReviewsRepo.save(reviews);
        orderItem.setIsEvaluated(true);
        orderItemRepo.save(orderItem);
        ratingInfo.setStar(reviews.getRating());
        ratingInfoRepo.save(ratingInfo);
    }
}
