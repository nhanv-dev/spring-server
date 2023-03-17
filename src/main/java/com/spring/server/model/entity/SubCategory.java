package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

}
