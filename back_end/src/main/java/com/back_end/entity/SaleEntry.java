package com.back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_entries")
public class SaleEntry extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
