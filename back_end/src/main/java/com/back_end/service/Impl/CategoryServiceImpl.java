package com.back_end.service.Impl;

import com.back_end.dto.CategoryDto;
import com.back_end.entity.Article;
import com.back_end.entity.Category;
import com.back_end.exception.InvalidOperationException;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.ArticleRepository;
import com.back_end.repository.CategoryRepository;
import com.back_end.service.CategoryService;
import com.back_end.validator.CategoryValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;
    private Mapper<Category, CategoryDto> mapper;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        String code = categoryDto.getCode();

        Category categoryByCode = categoryRepository.findCategoryByCode(code);

        if (categoryByCode != null) {
            errors.add("Duplicate code of category");
        }

        errors.addAll(CategoryValidator.validate(categoryDto));

        if (!errors.isEmpty()) {
            log.error("Category is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }
        Category category = categoryRepository.save(mapper.mapToEntity(categoryDto, Category.class));
        return mapper.mapToDto(category, CategoryDto.class);
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null) {
            log.error("Category id is null");
            throw new ResourceNotFoundException("Category id is null");
        }

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
        if (id == null) {
            log.error("Category id is null");
            throw new ResourceNotFoundException("Category id is null");
        }

        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", id));

        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete this category as it is already in use");
        }

        categoryRepository.delete(category);
    }

}
