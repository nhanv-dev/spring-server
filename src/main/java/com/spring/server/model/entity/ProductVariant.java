package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "variant")
@SQLDelete(sql = "UPDATE variant SET is_deleted = true WHERE id=?")
public class ProductVariant extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String attributeHash;
    @Column(columnDefinition = "bigint default 0")
    private Integer quantity;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deal_id", referencedColumnName = "id", unique = true)
    private Deal deal;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_option", joinColumns = @JoinColumn(name = "variant_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
    @Where(clause = "is_deleted=false")
    private Set<ProductAttributeOption> options = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
