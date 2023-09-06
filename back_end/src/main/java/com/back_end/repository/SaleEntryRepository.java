package com.back_end.repository;

import com.back_end.entity.SaleEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleEntryRepository extends JpaRepository<SaleEntry, Long> {

    List<SaleEntry> findAllByArticleId(Long articleId);

    List<SaleEntry> findAllBySaleId(Long saleId);

}
