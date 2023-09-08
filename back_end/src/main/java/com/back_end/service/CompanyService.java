package com.back_end.service;

import com.back_end.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);

    CompanyDto findById(Long id);

    List<CompanyDto> findAll();

    void delete(Long id);
}