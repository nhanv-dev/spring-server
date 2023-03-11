package com.spring.server.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeOptionDto {
    private Long id, attributeId;
    private String name, value, image;
    private boolean isDeleted;

}
