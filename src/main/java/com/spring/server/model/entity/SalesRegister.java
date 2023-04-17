package com.spring.server.model.entity;

import com.spring.server.model.constant.ESalesRegisterStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_register")
public class SalesRegister extends BaseEntity implements Serializable {
    @Column
    private ESalesRegisterStatus status;
    @Column
    private String shopName, shopEmail, shopPhone;
    @Column
    private String city, district, wards, addressDetail, warehouseRegionName;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;
}
