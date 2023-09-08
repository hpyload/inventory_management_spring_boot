package com.back_end.dto;

import com.back_end.entity.Address;
import com.back_end.entity.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private AddressDto address;

    private String photo;

    private String email;

    private String phone;

    private Long companyId;

    @JsonIgnore
    private List<CustomerOrderDto> customerOrders;

}
