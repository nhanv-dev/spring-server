package com.spring.server.payload.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import java.util.Set;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @Email
    @Size(max = 256)
    private String email;
    @NotBlank
    @Size(max = 256)
    private String name;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;

    private Set<String> role;


}
