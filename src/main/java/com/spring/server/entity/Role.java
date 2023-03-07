package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private ERole type;
    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
