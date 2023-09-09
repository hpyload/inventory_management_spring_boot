package com.back_end.service;

import com.back_end.dto.SaleDto;

import java.util.List;

public interface SaleService {

    SaleDto save(SaleDto customerDto);

    SaleDto findById(Long id);

    List<SaleDto> findAll();

    void delete(Long id);
}
