package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "return_policy")
public class ReturnPolicy extends BaseEntity {
    @Getter
    @Setter
    @Column
    private String title, tooltipTitle, tooltipContent;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "returnPolicies")
    private List<Product> products;
}
