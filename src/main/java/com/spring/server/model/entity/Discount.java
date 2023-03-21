package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount")
public class Discount extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private double price, finalPrice, discountPercent;
    @Column(columnDefinition = "boolean default false")
    private boolean isRunning;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
