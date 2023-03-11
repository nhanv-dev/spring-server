package com.spring.server.model.mapper;

import com.spring.server.model.entity.RatingInfo;
import com.spring.server.model.dto.RatingInfoDto;
import org.springframework.stereotype.Component;

@Component
public class RatingInfoMapper {


    public static RatingInfoDto toDto(RatingInfo ratingInfo) {
        RatingInfoDto result = new RatingInfoDto();

        result.setId(ratingInfo.getId());
        result.setStar1(ratingInfo.getStar1());
        result.setStar2(ratingInfo.getStar2());
        result.setStar3(ratingInfo.getStar3());
        result.setStar4(ratingInfo.getStar4());
        result.setStar5(ratingInfo.getStar5());

        result.setTotalRating(ratingInfo.getStar1() + ratingInfo.getStar2() + ratingInfo.getStar3() + ratingInfo.getStar4() + ratingInfo.getStar5());
        double avg = ((double) (ratingInfo.getStar1() + ratingInfo.getStar2() * 2 + ratingInfo.getStar3() * 3 + ratingInfo.getStar4() * 4 + ratingInfo.getStar5() * 5) / result.getTotalRating());
        result.setAvgRating(((double) Math.round(avg * 10)) / 10);
        return result;
    }

}
