package com.back_end.dto;

import com.back_end.entity.Supplier;
import com.back_end.entity.SupplierOrderLine;
import com.back_end.utils.OrderStatus;
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
public class SupplierOrderDto {

    private Long id;

    private String code;

    private Instant orderDate;

    private OrderStatus orderStatus;

    private Long companyId;

    private SupplierDto supplier;

    private List<SupplierOrderLineDto> supplierOrderLines;
}
