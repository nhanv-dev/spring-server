package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
    @Column
    private Double price, finalPrice, discountPercent;
    @Column
    private Boolean isRunning, isDeleted;
    @OneToOne(mappedBy = "discount")
    private Product product;
}
