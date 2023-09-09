package com.back_end.service;

import com.back_end.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    CustomerDto findById(Long id);

    List<CustomerDto> findAll();

    void delete(Long id);

}
