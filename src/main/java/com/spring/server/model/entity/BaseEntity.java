package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date createdAt;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updatedAt;

}
