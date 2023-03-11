package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingInfoDto extends BaseDto {
    private Integer star1, star2, star3, star4, star5;

    private Integer totalRating;

    private Double avgRating;
}
