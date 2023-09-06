package com.back_end.repository;

import com.back_end.entity.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine, Long> {

    List<SupplierOrderLine> findAllBySupplierOrderId(Long orderId);

    List<SupplierOrderLine> findAllByArticleId(Long articleId);

}
