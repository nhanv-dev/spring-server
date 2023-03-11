package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "role")
@NoArgsConstructor
public class Role extends BaseEntity {
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private ERole type;
    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(ERole type) {
        this.type = type;
    }
}
