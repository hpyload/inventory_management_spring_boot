package com.back_end.service.Impl;

import com.back_end.dto.CustomerDto;
import com.back_end.entity.Customer;
import com.back_end.entity.CustomerOrder;
import com.back_end.exception.InvalidOperationException;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.CustomerOrderRepository;
import com.back_end.repository.CustomerRepository;
import com.back_end.service.CustomerService;
import com.back_end.validator.CustomerValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerOrderRepository customerOrderRepository;
    private Mapper<Customer, CustomerDto> mapper;

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();

        String email = customerDto.getEmail();

        Customer customerByEmail = customerRepository.findCustomerByEmail(email);

        if (customerByEmail != null) {
            errors.add("Duplicate email of customer");
        }

        errors.addAll(CustomerValidator.validate(customerDto));

        if (!errors.isEmpty()) {
            log.error("Customer is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }
        Customer customer = customerRepository.save(mapper.mapToEntity(customerDto, Customer.class));
        return mapper.mapToDto(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto findById(Long id) {
        if (id == null) {
            log.error("Customer id is null");
            throw new ResourceNotFoundException("Customer id is null");
        }

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer", "customerId", id));
        return mapper.mapToDto(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapper.mapToDto(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Customer id is null");
            throw new ResourceNotFoundException("Customer id is null");
        }

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer", "customerId", id));

        List<CustomerOrder> customerOrders = customerOrderRepository.findAllByCustomerId(id);
        if (!customerOrders.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete this customer as it is already in use in customer orders");
        }

        customerRepository.delete(customer);
    }
}
