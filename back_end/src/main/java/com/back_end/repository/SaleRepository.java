package com.back_end.repository;

import com.back_end.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Optional<Sale> findSaleByCode(String saleCode);

}
