package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto implements Comparable<CategoryDto> {
    private Long id;
    private String title, slug, icon;
    private Set<SubCategoryDto> subCategories;
    @Override
    public int compareTo(CategoryDto o) {
        return id.compareTo(o.getId());
    }
}
