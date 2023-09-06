package com.back_end.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    private String firstName;

    private String lastName;

    @Embedded
    private Address address;

    private String photo;

    private String email;

    private String phone;

    private Long companyId;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

}
