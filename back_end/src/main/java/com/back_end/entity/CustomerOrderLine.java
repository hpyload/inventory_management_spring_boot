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
@Table(name = "customer_order_lines")
public class CustomerOrderLine extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "client_order_id")
    private CustomerOrder customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private Long companyId;

}
