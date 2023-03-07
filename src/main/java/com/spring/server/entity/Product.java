package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String name, shortDescription, description, slug, keywords;
    @Getter
    @Setter
    @Column
    private Integer quantity, orderCount;
    @Getter
    @Setter
    @Column
    Double price;
    @Getter
    @Setter
    @Column
    private boolean isPublic, isDeleted;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategory subCategory;
    @Getter
    @Setter
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private RatingInfo ratingInfo;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "product_return_policy",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "policy_id"))
    private List<ReturnPolicy> returnPolicies;

    @Getter
    @Setter
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductAttribute> attributes;
    @Getter
    @Setter
    private Date createdAt,updatedAt;
}
