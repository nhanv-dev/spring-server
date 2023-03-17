package com.spring.server.model.mapper;

import com.spring.server.model.dto.DiscountDto;
import com.spring.server.model.entity.Discount;
import com.spring.server.model.entity.RatingInfo;

public class DiscountMapper {
    public static DiscountDto toDto(Discount discount) {
        DiscountDto result = new DiscountDto();
        result.setPrice(discount.getPrice());
        result.setFinalPrice(discount.getFinalPrice());
        result.setDiscountPercent(discount.getDiscountPercent());
        result.setIsRunning(discount.getIsRunning());
        result.setIsDeleted(discount.getIsDeleted());
        return result;
    }

    public static Discount toEntity(DiscountDto discount) {
        Discount result = new Discount();
        result.setPrice(discount.getPrice());
        result.setFinalPrice(discount.getFinalPrice());
        result.setDiscountPercent(discount.getDiscountPercent());
        result.setIsRunning(discount.getIsRunning());
        result.setIsDeleted(discount.getIsDeleted());
        return result;
    }

}
