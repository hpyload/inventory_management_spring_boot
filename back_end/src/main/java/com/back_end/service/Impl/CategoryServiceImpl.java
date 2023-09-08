package com.back_end.service.Impl;

import com.back_end.dto.CategoryDto;
import com.back_end.entity.Category;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.CategoryRepository;
import com.back_end.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private Mapper<Category, CategoryDto> mapper;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryRepository.save(mapper.mapToEntity(categoryDto, Category.class));
        return mapper.mapToDto(category, CategoryDto.class);
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", id));
        return mapper.mapToDto(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> mapper.mapToDto(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", id));
        categoryRepository.delete(category);
    }

}
