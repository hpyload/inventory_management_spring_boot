package com.back_end.service;

import com.back_end.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Long id);

    List<ArticleDto> findAll();

    void delete(Long id);
}
