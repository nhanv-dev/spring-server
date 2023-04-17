package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attribute_option")
@SQLDelete(sql = "UPDATE attribute_option SET is_deleted = true WHERE id=?")
public class ProductAttributeOption extends BaseEntity implements Serializable {
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String name, value;
    @Column(columnDefinition = "text")
    private String image;
    @Column(columnDefinition = "boolean")
    private boolean isDeleted = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    private ProductAttribute attribute;
    @ManyToMany(mappedBy = "options")
    private Set<ProductVariant> variants;

}
