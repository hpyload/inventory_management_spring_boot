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
@Table(name = "customer_orders")
public class CustomerOrder extends BaseEntity{

    private String code;

    private Instant orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long companyId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderLine> customerOrderLines;

}
