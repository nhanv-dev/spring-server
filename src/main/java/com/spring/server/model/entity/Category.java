package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category extends BaseEntity implements Serializable {
    @Column(columnDefinition = "varchar(100) not null unique")
    private String title;
    @Column(columnDefinition = "varchar(255) unique")
    private String slug;
    @Column(columnDefinition = "text")
    private String icon;
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<SubCategory> subCategories = new HashSet<>();
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

}
