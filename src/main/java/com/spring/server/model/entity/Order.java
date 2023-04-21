package com.spring.server.model.entity;

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
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {
    @Column(columnDefinition = "double not null", nullable = false)
    private double totalPrice;
    @Column
    private String note;
    @ManyToOne
    @JoinColumn(name = "user_address_id", nullable = false)
    private UserAddress userAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private OrderStatus orderStatus;
    @OneToOne(mappedBy = "order")
    private CancelledOrder cancelledOrder;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderStatusHistory> orderStatusHistories = new HashSet<>();

    public void addHistory(OrderStatusHistory history) {
        orderStatusHistories.add(history);
    }
}
