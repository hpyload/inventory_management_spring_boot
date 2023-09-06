package com.back_end.repository;

import com.back_end.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    @Query("SELECT SUM (s.quantity) from StockMovement s WHERE s.article.id =: articleId")
    BigDecimal realStock(@Param("articleId") Long articleId);

    List<StockMovement> findAllByArticleId(Long articleId);

}
