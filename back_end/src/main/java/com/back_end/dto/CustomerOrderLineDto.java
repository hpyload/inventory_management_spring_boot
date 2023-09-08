package com.back_end.dto;

import com.back_end.entity.Article;
import com.back_end.entity.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderLineDto {

    private Long id;

    private ArticleDto article;

    @JsonIgnore
    private CustomerOrderDto customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
