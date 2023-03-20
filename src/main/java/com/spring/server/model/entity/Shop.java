package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop")
public class Shop extends BaseEntity implements Serializable {
    @Column
    private String shopName, email, phoneNumber, slug, shopSlogan, shopLogo, shopBackground;
    @Column
    private String city, district, wards, addressDetail, warehouseRegionName;
    @Column(columnDefinition = "varchar(255) default 'Đang cập nhật'")
    private String responseTime, timePrepareProduct;
    @Column(columnDefinition = "bigint default 0")
    private Integer productTotal = 0;
    @Column(columnDefinition = "boolean default false")
    private boolean isOfficialShop, isDeleted;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rating_id", referencedColumnName = "id", nullable = false, unique = true)
    private RatingInfo ratingInfo;
    @OneToMany(mappedBy = "shop", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ShopReviews> reviews = new HashSet<>();
}
