package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "variant")
public class ProductVariant extends BaseEntity {
    @Column
    private String attributeHash;
    @Column
    private String skuUser;
    @Column
    private Double price;
    @Column
    private Integer quantity;
    @Column
    private boolean isDeleted;
    @ManyToMany
    @JoinTable(name = "variant_option", joinColumns = @JoinColumn(name = "variant_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<ProductAttributeOption> options;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
