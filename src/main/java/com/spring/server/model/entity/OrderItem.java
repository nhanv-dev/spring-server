package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_item")
public class OrderItem extends BaseEntity implements Serializable {
    @Column(columnDefinition = "double not null")
    private double discountPercent;
    @Column(columnDefinition = "double not null")
    private double price;
    @Column(columnDefinition = "double not null")
    private double finalPrice;
    @Column(columnDefinition = "bigint not null")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

}
