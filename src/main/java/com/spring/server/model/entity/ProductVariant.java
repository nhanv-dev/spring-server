package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "variant")
public class ProductVariant extends BaseEntity implements Serializable {
    @Column(columnDefinition = "varchar(255) not null")
    private String attributeHash;
    @Column(columnDefinition = "varchar(255)")
    private String skuUser;
    @Column
    private Double price;
    @Column(columnDefinition = "bigint default 0")
    private Integer quantity;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "variant_option", joinColumns = @JoinColumn(name = "variant_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
    private Set<ProductAttributeOption> options;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
