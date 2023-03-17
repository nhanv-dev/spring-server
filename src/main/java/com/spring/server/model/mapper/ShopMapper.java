package com.spring.server.model.mapper;

import com.spring.server.model.entity.Shop;
import com.spring.server.model.dto.ShopDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopMapper {

    public static ShopDto toDto(Shop shop) {
        ShopDto result = new ShopDto();

        result.setId(shop.getId());
        result.setShopName(shop.getShopName());
        result.setSlug(shop.getSlug());
        result.setShopLogo(shop.getShopLogo());
        result.setShopBackground(shop.getShopBackground());
        result.setResponseTime(shop.getResponseTime());
        result.setTimePrepareProduct(shop.getTimePrepareProduct());
        result.setProductTotal(shop.getProductTotal());
        result.setOfficial(shop.isOfficialShop());
        result.setRatingInfo(RatingInfoMapper.toDto(shop.getRatingInfo()));

        result.setCity(shop.getCity());
        result.setDistrict(shop.getDistrict());
        result.setWards(shop.getWards());
        result.setWarehouseRegionName(shop.getWarehouseRegionName());
        result.setDeleted(shop.isDeleted());

        return result;
    }

    public static List<ShopDto> toDto(List<Shop> shops) {

        return null;
    }

    public static Shop toEntity(ShopDto shop) {
        Shop result = new Shop();

        result.setId(shop.getId());
        result.setShopName(shop.getShopName());
        result.setSlug(shop.getSlug());
        result.setShopLogo(shop.getShopLogo());
        result.setShopBackground(shop.getShopBackground());
        result.setResponseTime(shop.getResponseTime());
        result.setTimePrepareProduct(shop.getTimePrepareProduct());
        result.setProductTotal(shop.getProductTotal());
        result.setOfficialShop(shop.isOfficial());
        result.setRatingInfo(RatingInfoMapper.toEntity(shop.getRatingInfo()));

        result.setCity(shop.getCity());
        result.setDistrict(shop.getDistrict());
        result.setWards(shop.getWards());
        result.setWarehouseRegionName(shop.getWarehouseRegionName());
        result.setDeleted(shop.isDeleted());
        return result;
    }
}
