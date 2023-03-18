package com.spring.server.model.mapper;

import com.spring.server.model.dto.DiscountDto;
import com.spring.server.model.entity.Discount;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.RatingInfo;

import java.util.HashSet;
import java.util.Set;

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

    public static DiscountDto toDtoWithRunning(Set<Discount> discounts) {
        for (Discount discount : discounts) {
            if (discount.getIsRunning()) return DiscountMapper.toDto(discount);
        }
        return null;
    }

    public static Set<DiscountDto> toDtos(Set<Discount> discounts) {
        Set<DiscountDto> result = new HashSet<>();
        if (discounts == null || discounts.isEmpty()) return result;
        for (Discount discount : discounts) {
            DiscountDto mapped = new DiscountDto();
            mapped.setPrice(discount.getPrice());
            mapped.setFinalPrice(discount.getFinalPrice());
            mapped.setDiscountPercent(discount.getDiscountPercent());
            mapped.setIsRunning(discount.getIsRunning());
            mapped.setIsDeleted(discount.getIsDeleted());
            result.add(mapped);
        }
        return result;
    }

    public static Discount toEntity(DiscountDto discount, Product product) {
        Discount result = new Discount();

        result.setPrice(discount.getPrice());
        result.setFinalPrice(discount.getFinalPrice());
        result.setDiscountPercent(discount.getDiscountPercent());
        result.setIsRunning(discount.getIsRunning());
        result.setIsDeleted(discount.getIsDeleted());
        result.setProduct(product);

        return result;
    }

    public static Set<Discount> toEntities(DiscountDto discount, Product product) {
        Set<Discount> result = new HashSet<>();
        result.add(DiscountMapper.toEntity(discount, product));
        return result;
    }

    public static Set<Discount> toEntities(Set<DiscountDto> discounts, Product product) {
        Set<Discount> result = new HashSet<>();
        if (discounts == null || discounts.isEmpty()) return result;
        for (DiscountDto discount : discounts) {
            result.add(DiscountMapper.toEntity(discount, product));
        }
        return result;
    }
}
