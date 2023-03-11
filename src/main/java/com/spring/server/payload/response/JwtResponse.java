package com.spring.server.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private String name;
    private List<String> roles;

    public JwtResponse(String jwt, Long id, String email,  String name,  List<String> roles) {
        this.token = jwt;
        this.id = id;
        this.email = email;
        this.name = name;
        this.roles = roles;
    }
}
