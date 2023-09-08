package com.back_end.dto;

import com.back_end.entity.CustomerOrderLine;
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
public class CustomerOrderDto {

    private Long id;

    private String code;

    private Instant orderDate;

    private OrderStatus orderStatus;

    private Long companyId;

    private List<CustomerOrderLineDto> customerOrderLines;

}
