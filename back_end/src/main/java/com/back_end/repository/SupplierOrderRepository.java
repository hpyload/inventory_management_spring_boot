package com.back_end.repository;

import com.back_end.entity.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {

    Optional<SupplierOrder> findSupplierOrderByCode(String orderCode);

    List<SupplierOrder> findAllBySupplierId(Long supplierId);

}
