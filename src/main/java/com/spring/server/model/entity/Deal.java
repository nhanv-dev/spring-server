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
public class Deal extends BaseEntity implements Serializable {
    @Column(columnDefinition = "decimal(15,2)", nullable = false)
    private double price;
    @Column(columnDefinition = "decimal(15,2)")
    private double finalPrice;
    @Column()
    private double discountPercent;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;
}
