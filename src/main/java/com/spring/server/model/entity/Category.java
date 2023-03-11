package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String title;
    @Getter
    @Setter
    @Column
    private String slug;
    @Getter
    @Setter
    @Column
    private String icon;
    @Getter
    @Setter
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCategory> subCategories;

    @OneToOne(mappedBy = "category")
    private Product product;

}
