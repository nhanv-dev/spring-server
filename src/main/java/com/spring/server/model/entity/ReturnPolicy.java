package com.spring.server.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "return_policy")
public class ReturnPolicy extends BaseEntity implements Serializable {
    @Getter
    @Setter
    @Column
    private String title, tooltipTitle, tooltipContent;

}
