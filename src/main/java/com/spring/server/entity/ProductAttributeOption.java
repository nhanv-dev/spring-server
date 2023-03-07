package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "attribute_option")
public class ProductAttributeOption extends BaseEntity {
    @Getter
    @Setter
    @Column(nullable = false)
    private String name, value;
    @Getter
    @Setter
    @Column
    private String image;
    @Getter
    @Setter
    @Column(nullable = false)
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    private ProductAttribute attribute;

}
