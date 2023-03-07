package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private Set<RoleDto> roles;
}
