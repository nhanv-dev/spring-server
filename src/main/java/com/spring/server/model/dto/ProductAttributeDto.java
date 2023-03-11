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
public class ProductAttributeDto {
    private Long id;
    private String name;
    private Set<ProductAttributeOptionDto> options;
}
