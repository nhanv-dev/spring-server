package com.spring.server.model.mapper;

import com.spring.server.model.entity.Shop;
import com.spring.server.model.dto.ShopDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ShopMapper {

    public static ShopDto toDto(Shop shop) {
        ShopDto result = ShopMinimalMapper.toDto(shop);
        result.setShopSlogan(shop.getShopSlogan());
        result.setShopBackground(shop.getShopBackground());
        result.setResponseTime(shop.getResponseTime());
        result.setTimePrepareProduct(shop.getTimePrepareProduct());
        result.setCity(shop.getCity());
        result.setAddressDetail(shop.getAddressDetail());
        result.setDistrict(shop.getDistrict());
        result.setWards(shop.getWards());
        result.setWarehouseRegionName(shop.getWarehouseRegionName());
        result.setDeleted(shop.isDeleted());

        return result;
    }

    public static Set<ShopDto> toDto(Set<Shop> shops) {
        if (shops == null || shops.isEmpty()) return null;
        Set<ShopDto> result = new HashSet<>();
        for (Shop shop : shops) result.add(toDto(shop));
        return result;
    }

    public static Shop toEntity(ShopDto shop) {
        Shop result = new Shop();

        result.setId(shop.getId());
        result.setShopName(shop.getShopName());
        result.setEmail(shop.getShopEmail());
        result.setPhoneNumber(shop.getShopPhone());
        result.setShopSlogan(shop.getShopSlogan());
        result.setSlug(shop.getSlug());
        result.setShopLogo(shop.getShopLogo());
        result.setShopBackground(shop.getShopBackground());
        result.setResponseTime(shop.getResponseTime());
        result.setTimePrepareProduct(shop.getTimePrepareProduct());
        result.setProductTotal(shop.getProductTotal());
        result.setOfficialShop(shop.isOfficial());
        result.setRatingInfo(RatingInfoMapper.toEntity(shop.getRatingInfo()));
        result.setAddressDetail(shop.getAddressDetail());
        result.setCity(shop.getCity());
        result.setDistrict(shop.getDistrict());
        result.setWards(shop.getWards());
        result.setWarehouseRegionName(shop.getWarehouseRegionName());
        result.setDeleted(shop.isDeleted());
        return result;
    }
}
