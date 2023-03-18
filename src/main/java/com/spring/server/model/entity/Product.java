package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {
    @Column
    private String name, shortDescription, description, slug, keywords;
    @Column
    private Integer quantity, orderCount;
    @Column
    Double price;
    @Column
    private boolean isPublic, isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategory subCategory;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private RatingInfo ratingInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<Discount> discounts = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "product_return_policy", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "policy_id"))
    private Set<ReturnPolicy> returnPolicies = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductAttribute> attributes = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductVariant> variants = new HashSet<>();
    @Column
    private Date createdAt, updatedAt;
}
