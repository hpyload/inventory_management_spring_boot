package com.back_end.controller;

import com.back_end.dto.CustomerDto;
import com.back_end.dto.CustomerDto;
import com.back_end.service.ArticleService;
import com.back_end.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.save(customerDto), HttpStatus.CREATED);
    }

    @GetMapping( "/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(value = "customerId") Long customerId) {
        return new ResponseEntity<>(customerService.findById(customerId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping( "/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(value = "customerId") Long customerId) {
        customerService.delete(customerId);
        return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
    }
}
