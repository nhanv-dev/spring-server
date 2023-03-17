package com.spring.server.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeDto {
    private Long id;
    private String name;
    private Set<ProductAttributeOptionDto> options;
}
