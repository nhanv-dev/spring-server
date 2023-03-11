package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "shop")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Shop extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
    @Column(columnDefinition = "varchar(255) default 'Đang cập nhật'")
    private String responseTime = "Đang cập nhật", timePrepareProduct = "Đang cập nhật";
    @Getter
    @Setter
    @Column(columnDefinition = "bigint default 0")
    private Integer productTotal = 0;
    @Getter
    @Setter
    @Column(columnDefinition = "boolean default false")
    private boolean isOfficialShop, isDeleted;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private RatingInfo ratingInfo;
}
