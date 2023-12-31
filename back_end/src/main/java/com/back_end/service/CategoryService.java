package com.back_end.service;


import com.back_end.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Long id);

    List<CategoryDto> findAll();

    void delete(Long id);

}
