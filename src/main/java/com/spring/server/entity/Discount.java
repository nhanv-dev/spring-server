package com.spring.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class Discount extends BaseEntity {
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddress> addresses;


}
