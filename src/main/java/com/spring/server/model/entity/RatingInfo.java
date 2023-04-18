package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "rating_info")
public class RatingInfo extends BaseEntity implements Serializable {

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

    public void setStar(Integer star) {
        switch (star) {
            case 1:
                star1++;
                break;
            case 2:
                star2++;
                break;
            case 3:
                star3++;
                break;
            case 4:
                star4++;
                break;
            case 5:
                star5++;
                break;
        }
    }
}
