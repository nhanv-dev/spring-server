package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {
    @Column(columnDefinition = "varchar(255) not null")
    private String name;
    @Column(columnDefinition = "varchar(255) not null unique")
    private String email;
    @Column(columnDefinition = "varchar(255) not null")
    private String password;
    @Column(columnDefinition = "varchar(10) not null")
    private String phoneNumber;
    @OneToOne(mappedBy = "user")
    private Shop shop;
//    @OneToOne(mappedBy = "user")
//    private SalesRegister salesRegister;
    //    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private Set<Cart> carts = new HashSet<>();
//    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private Set<Order> orders = new HashSet<>();
//    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private Set<ProductReviews> reviews = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<UserAddress> addresses = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password, String name, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
