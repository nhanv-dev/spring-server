package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private Long id;
    private String shopName;
    private String shopPhone;
    private String shopEmail;
    private String shopSlogan;
    private String shopLogo, shopBackground;
    private String city, district, wards, addressDetail, warehouseRegionName;
    private String slug;
    private String responseTime, timePrepareProduct;
    private boolean isDeleted, isOfficial;
    private Integer productTotal;
    private Integer orderCount;
    private RatingInfoDto ratingInfo;
}
