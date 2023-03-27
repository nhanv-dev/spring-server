package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deal")
@SQLDelete(sql = "UPDATE deal SET is_deleted = true WHERE id=?")
//@Where(clause = "is_deleted=false")
public class Deal extends BaseEntity implements Serializable {
    @Column(nullable = false, columnDefinition = "decimal(15,2)")
    private double price;
    @Column(columnDefinition = "decimal(15,2)")
    private double finalPrice;
    @Column()
    private double discountPercent;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;
    @OneToOne(mappedBy = "deal")
    private Product product;
    @OneToOne(mappedBy = "deal")
    private ProductVariant variant;
}