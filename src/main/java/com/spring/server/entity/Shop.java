package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "shop")
public class Shop extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String shopName, email, phoneNumber, slug, shopSlogan, shopLogo, shopBackground;
    @Getter
    @Setter
    @Column
    private String city, district, wards, addressDetail, warehouseRegionName;
    @Getter
    @Setter
    @Column
    private String responseTime, timePrepareProduct;
    @Getter
    @Setter
    @Column
    private Integer productTotal;
    @Getter
    @Setter
    @Column
    private boolean isOfficialShop, isDeleted;
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private RatingInfo ratingInfo;
}
