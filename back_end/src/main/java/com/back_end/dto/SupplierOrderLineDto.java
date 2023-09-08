package com.back_end.dto;

import com.back_end.entity.Article;
import com.back_end.entity.SupplierOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOrderLineDto {

    private Long id;

    private ArticleDto article;

    private SupplierOrderDto supplierOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
