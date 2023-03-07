package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "attribute")
public class ProductAttribute extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductAttributeOption> options;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
