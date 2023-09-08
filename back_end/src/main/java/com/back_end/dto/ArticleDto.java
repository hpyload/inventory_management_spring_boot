package com.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Long id;

    private String code;

    private String designation;

    private BigDecimal netUnitPrice;

    private BigDecimal taxRate;

    private BigDecimal grossUnitPrice;

    private String photo;

    private Long companyId;

}
