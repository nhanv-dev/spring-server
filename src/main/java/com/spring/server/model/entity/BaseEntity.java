package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
//    @Column(columnDefinition = "timestamp default NOW()", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @LastModifiedDate
    protected Date createdAt;
//    @Column(columnDefinition = "timestamp default NOW() ON UPDATE NOW()")
    @UpdateTimestamp
    @LastModifiedDate
    protected Date updatedAt;
}
