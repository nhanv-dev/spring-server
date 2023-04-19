package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Temporal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product p  SET p.is_deleted = true WHERE p.id=?")
public class Product extends BaseEntity implements Serializable {
    @Column
    private String name;
    @Column(unique = true)
    private String slug;
    @Column
    private String keywords;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String shortDescription;
    @Column(nullable = false)
    private Integer quantity;
    @Column
    private Integer orderCount;
    @Column(columnDefinition = "boolean default true")
    private Boolean isPublic;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id", unique = true)
    private RatingInfo ratingInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deal_id", referencedColumnName = "id", unique = true)
    private Deal deal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id", nullable = false)
    private SubCategory subCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private Shop shop;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "is_deleted=false")
    private Set<ProductAttribute> attributes = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "is_deleted=false")
    private Set<ProductVariant> variants = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "product_return_policy", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "policy_id"))
    private Set<ReturnPolicy> returnPolicies = new HashSet<>();


    @PrePersist
    public void prePersist() {
        if (isPublic == null) isPublic = true;
        if (isDeleted == null) isDeleted = false;
        if (orderCount == null) orderCount = 0;
    }
}
