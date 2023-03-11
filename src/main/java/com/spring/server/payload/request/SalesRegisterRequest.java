package com.spring.server.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
public class SalesRegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String shopName;
    @NotBlank
    private String warehouse;

    private String city, district, wards, address;


}
