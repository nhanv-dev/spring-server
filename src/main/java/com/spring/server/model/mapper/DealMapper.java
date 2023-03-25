package com.spring.server.model.mapper;

import com.spring.server.model.dto.DealDto;
import com.spring.server.model.entity.Deal;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DealMapper {
    public static DealDto toDto(Deal deal) {
        DealDto result = new DealDto();
        result.setPrice(deal.getPrice());
        result.setFinalPrice(deal.getFinalPrice());
        result.setDiscountPercent(deal.getDiscountPercent());
        result.setId(deal.getId());
        return result;
    }

    public static Set<DealDto> toDtos(Set<Deal> deals) {
        Set<DealDto> result = new HashSet<>();
        if (deals == null || deals.isEmpty()) return result;
        for (Deal deal : deals) {
            if (deal == null) continue;
            DealDto mapped = new DealDto();
            mapped.setId(deal.getId());
            mapped.setPrice(deal.getPrice());
            mapped.setFinalPrice(deal.getFinalPrice());
            mapped.setDiscountPercent(deal.getDiscountPercent());
            result.add(mapped);
        }
        return result;
    }

    public static Deal toEntity(DealDto deal) {
        if (deal == null) return null;
        Deal result = new Deal();
        result.setPrice(deal.getPrice());
        result.setFinalPrice(deal.getFinalPrice());
        result.setDiscountPercent(deal.getDiscountPercent());
//        result.setProduct(product);
        return result;
    }

    public static Deal toEntity(DealDto deal, ProductVariant variant) {
        if (deal == null) return null;
        Deal result = new Deal();
        result.setPrice(deal.getPrice());
        result.setFinalPrice(deal.getFinalPrice());
        result.setDiscountPercent(deal.getDiscountPercent());
        result.setVariant(variant);
        return result;
    }
}
