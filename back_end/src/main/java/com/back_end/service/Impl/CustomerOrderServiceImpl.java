package com.back_end.service.Impl;

import com.back_end.dto.CustomerOrderDto;
import com.back_end.entity.CustomerOrder;
import com.back_end.mapper.Mapper;
import com.back_end.repository.CustomerOrderRepository;
import com.back_end.service.CustomerOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;
    private Mapper<CustomerOrder, CustomerOrderDto> mapper;

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        return null;
    }

    @Override
    public CustomerOrderDto findById(Long id) {
        return null;
    }

    @Override
    public CustomerOrderDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
