package com.back_end.repository;

import com.back_end.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Supplier findSupplierByEmail(String email);

}
