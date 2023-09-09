package com.back_end.service;

import com.back_end.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto supplierDto);

    SupplierDto findById(Long id);

    List<SupplierDto> findAll();

    void delete(Long id);
}
