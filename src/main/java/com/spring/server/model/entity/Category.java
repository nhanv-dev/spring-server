package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


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
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    @OrderBy("id")
    private Set<SubCategory> subCategories = new TreeSet<>();
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

}
