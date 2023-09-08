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
@Table(name = "supplier_order_lines")
public class SupplierOrderLine extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "supplier_order_id")
    private SupplierOrder supplierOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
