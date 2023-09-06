package com.back_end.entity;

import com.back_end.utils.StockMovementSource;
import com.back_end.utils.StockMovementType;
import jakarta.persistence.*;
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
@Entity
@Table(name = "stock_movements")
public class StockMovement extends BaseEntity{
    private Instant movementDate;

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Enumerated(EnumType.STRING)
    private StockMovementType stockMovementType;

    @Enumerated(EnumType.STRING)
    private StockMovementSource stockMovementSource;

    private Long companyId;

}
