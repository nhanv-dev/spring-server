package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "rating_info")
public class RatingInfo extends BaseEntity implements Serializable {
    @Getter
    @Setter
    @Column(columnDefinition = "tinyint default 0")
    private Integer star1, star2, star3, star4, star5;
    @OneToOne(mappedBy = "ratingInfo")
    private Product product;
    @OneToOne(mappedBy = "ratingInfo")
    private Shop shop;

    public RatingInfo() {
        this.star1 = 0;
        this.star2 = 0;
        this.star3 = 0;
        this.star4 = 0;
        this.star5 = 0;
    }
}
