package com.back_end.dto;


import com.back_end.entity.Article;
import com.back_end.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntryDto {

    private Long id;

    private SaleDto sale;

    private ArticleDto article;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
