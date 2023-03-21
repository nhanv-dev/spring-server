package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity()
@Table(name = "user_address")
public class UserAddress extends BaseEntity implements Serializable {
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
