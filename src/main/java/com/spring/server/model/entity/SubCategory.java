package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "subCategory")
    private Product product;

}
