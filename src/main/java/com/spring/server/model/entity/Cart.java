package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity implements Serializable {
    @Column(columnDefinition = "double not null")
    private double totalPrice;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<CartItem> items;

}
