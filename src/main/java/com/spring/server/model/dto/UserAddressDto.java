package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAddressDto implements Comparable<UserAddressDto> {
    private Long id, userId;
    private String city, district, wards, addressDetail, customerName, phoneNumber, email;
    private Date createdAt, updatedAt;
    @Override
    public int compareTo(UserAddressDto o) {
        return createdAt.compareTo(o.getCreatedAt());
    }
}
