package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity()
@Table(name = "user_address")
@SQLDelete(sql = "update user_address u set u.is_deleted=true where u.id=:id")
public class UserAddress extends BaseEntity implements Serializable {
    @Column
    private String city, district, wards, addressDetail, customerName, phoneNumber, email;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = false, isDefault = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "userAddress", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();
}
