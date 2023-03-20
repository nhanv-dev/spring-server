package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "varchar(255) unique")
    private String slug;
    @Column(columnDefinition = "varchar(255)")
    private String keywords;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String shortDescription;
    @Column(columnDefinition = "bigint not null")
    private Integer quantity;
    @Column(columnDefinition = "bigint")
    private Integer orderCount;
    @Column(columnDefinition = "decimal(15,2) not null")
    Double price;
    @Column(columnDefinition = "boolean default true")
    private boolean isPublic;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private RatingInfo ratingInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id",nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategory subCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Discount> discounts = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ProductAttribute> attributes = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ProductVariant> variants = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ProductReviews> reviews = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "product_return_policy", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "policy_id"))
    private Set<ReturnPolicy> returnPolicies = new HashSet<>();
}
