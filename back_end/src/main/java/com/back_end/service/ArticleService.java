package com.back_end.service;

import com.back_end.dto.*;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Long id);

    List<ArticleDto> findAll();

    List<ArticleDto> findAllByCategoryId(Long categoryId);

    List<SaleEntryDto> findSaleHistory(Long articleId);


    List<CustomerOrderLineDto> findCustomerOrderHistory(Long articleId);

    List<SupplierOrderLineDto> findSupplierOrderHistory(Long articleId);

    void delete(Long id);
}
