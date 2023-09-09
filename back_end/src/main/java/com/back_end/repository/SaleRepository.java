package com.back_end.repository;

import com.back_end.entity.Sale;
import com.back_end.entity.SaleEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Sale findSaleByCode(String saleCode);

}
