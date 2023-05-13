package com.spring.server.model.entity;

import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.constant.ERole;
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
@Table(name = "orders_status")
public class OrderStatus extends BaseEntity implements Serializable {
    @Enumerated(EnumType.STRING)
    @Column
    private EOrderStatus status;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String labelConfirm;
    @Column
    private String labelCreatedAt;
//    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private Set<Order> orders = new HashSet<>();
//    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private Set<OrderStatusHistory> orderStatusHistories = new HashSet<>();
}
