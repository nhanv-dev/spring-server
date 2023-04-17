package com.spring.server.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;


}
