package com.back_end.repository;

import com.back_end.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    Optional<CustomerOrder> findCustomerOrderByCode(String orderCode);

    List<CustomerOrder> findAllByCustomerId(Long customerId);

}
