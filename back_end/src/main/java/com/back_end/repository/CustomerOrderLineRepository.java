package com.back_end.repository;

import com.back_end.entity.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Long> {

    List<CustomerOrderLine> findAllByCustomerOrderId(Long customerOrderId);

    List<CustomerOrderLine> findAllByArticleId(Long articleId);

}
