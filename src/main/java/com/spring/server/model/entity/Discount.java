package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
    @Column
    private Double price, finalPrice, discountPercent;
    @Column
    private Boolean isRunning, isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
