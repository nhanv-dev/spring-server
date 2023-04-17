package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.server.model.constant.ESalesRegisterStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesRegisterDto implements Comparable<SalesRegisterDto> {
    private Long id, userId;
    private ESalesRegisterStatus status;
    private String shopName;
    private String shopPhone;
    private String shopEmail;
    private String city, district, wards, addressDetail, warehouseRegionName;
    private UserDto user;
    private Date createdDate, updatedDate;

    @Override
    public int compareTo(SalesRegisterDto o) {
        return createdDate.compareTo(o.getCreatedDate());
    }
}
