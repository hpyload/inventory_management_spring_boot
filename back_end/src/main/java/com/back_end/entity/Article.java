package com.back_end.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article extends BaseEntity{

    private String code;

    private String designation;

    private BigDecimal netUnitPrice;

    private BigDecimal taxRate;

    private BigDecimal grossUnitPrice;

    private String photo;

    private Long companyId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<SaleEntry> salesEntries;

    @OneToMany(mappedBy = "article")
    private List<CustomerOrderLine> customerOrderLines;

    @OneToMany(mappedBy = "article")
    private List<SupplierOrderLine> supplierOrderLines;

    @OneToMany(mappedBy = "article")
    private List<StockMovement> stockMovements;

}
