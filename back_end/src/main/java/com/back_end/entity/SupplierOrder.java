package com.back_end.entity;

import com.back_end.utils.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_orders")
public class SupplierOrder extends BaseEntity{

    private String code;

    private Instant orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long companyId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierOrder")
    private List<SupplierOrderLine> supplierOrderLines;

}
