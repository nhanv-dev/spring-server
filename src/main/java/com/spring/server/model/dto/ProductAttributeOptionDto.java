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
public class ProductAttributeOptionDto {
    private Long id, attributeId;
    private String name, value, image;
    private boolean isDeleted;

}
