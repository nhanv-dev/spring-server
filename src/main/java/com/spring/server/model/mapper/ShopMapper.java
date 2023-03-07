package com.spring.server.model.mapper;

import com.spring.server.entity.Category;
import com.spring.server.entity.Shop;
import com.spring.server.entity.SubCategory;
import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.ShopDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMapper {

    public static ShopDto toDto(Shop shop) {
        ShopDto result = new ShopDto();
        result.setId(shop.getId());
        result.setShopName(shop.getShopName());
        result.setDeleted(shop.isDeleted());
        result.setSlug(shop.getSlug());
        result.setCity(shop.getCity());
        result.setDistrict(shop.getDistrict());
        return result;
    }

    public static List<ShopDto> toDto(List<Shop> shops) {

        return null;
    }

    public static Shop toEntity(ShopDto shop) {

        return null;
    }
}
