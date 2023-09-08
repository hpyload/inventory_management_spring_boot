package com.back_end.dto;

import com.back_end.entity.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;

    private String code;

    private String designation;

    private Long companyId;

    @JsonIgnore
    private List<ArticleDto> articles;

}
