package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "sub_category")
public class SubCategory extends BaseEntity implements Serializable {
    @Column
    private String title;
    @Column
    private String slug;
    @Column
    private String icon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
