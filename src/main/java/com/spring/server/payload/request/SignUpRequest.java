package com.spring.server.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;

    @NotBlank
    private String phoneNumber;

    private Set<String> role;


}
