package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "user_address")
public class UserAddress extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String city, district, wards, addressDetail, customerName, phoneNumber, email;
    @Column
    @Getter
    @Setter
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
