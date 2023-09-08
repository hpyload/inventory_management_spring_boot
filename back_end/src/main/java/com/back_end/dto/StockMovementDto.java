package com.back_end.dto;

import com.back_end.entity.Article;
import com.back_end.utils.StockMovementSource;
import com.back_end.utils.StockMovementType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementDto {

    private Long id;

    private Instant movementDate;

    private BigDecimal quantity;

    private ArticleDto article;

    private StockMovementType stockMovementType;

    private StockMovementSource stockMovementSource;

    private Long companyId;

}
