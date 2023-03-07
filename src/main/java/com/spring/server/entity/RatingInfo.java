package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "rating_info")
public class RatingInfo extends BaseEntity {
    @Getter
    @Setter
    @Column
    private Integer star1, star2, star3, star4, star5;
    @OneToOne(mappedBy = "ratingInfo")
    private Product product;
    @OneToOne(mappedBy = "ratingInfo")
    private Shop shop;

}
