package com.back_end.service;

import com.back_end.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Long id);

    CustomerOrderDto findByCode(String code);

    List<CustomerOrderDto> findAll();

    void delete(Long id);
}
