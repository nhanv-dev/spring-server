package com.spring.server.model.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private Set<RoleDto> roles;
}
