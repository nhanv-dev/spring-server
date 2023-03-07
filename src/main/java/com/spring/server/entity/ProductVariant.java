package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "variant")
public class ProductVariant extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String attributeHash;
    @Getter
    @Setter
    @Column
    private String skuUser;
    @Getter
    @Setter
    @Column
    private Double price;
    @Getter
    @Setter
    @Column
    private Integer quantity;
    @Getter
    @Setter
    @Column
    private boolean isDeleted;



}
