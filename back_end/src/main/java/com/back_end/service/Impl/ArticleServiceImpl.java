package com.back_end.service.Impl;

import com.back_end.dto.ArticleDto;
import com.back_end.dto.CategoryDto;
import com.back_end.entity.Article;
import com.back_end.entity.Category;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.ArticleRepository;
import com.back_end.service.ArticleService;
import com.back_end.validator.ArticleValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private Mapper<Article, ArticleDto> mapper;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        String code = articleDto.getCode();

        Article articleByCode = articleRepository.findArticleByCode(code);

        if (articleByCode != null) {
            errors.add("Duplicate code of article");
        }
        errors.addAll(ArticleValidator.validate(articleDto));

        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }

        Article article = articleRepository.save(mapper.mapToEntity(articleDto, Article.class));

        return mapper.mapToDto(article, ArticleDto.class);
    }

    @Override
    public ArticleDto findById(Long id) {

        if (id == null) {
            log.error("Article id is null");
            throw new ResourceNotFoundException("Article id is null");
        }

        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article", "articleId", id));

        return mapper.mapToDto(article, ArticleDto.class);
    }

    @Override
    public List<ArticleDto> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(article -> mapper.mapToDto(article, ArticleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Article id is null");
            throw new ResourceNotFoundException("Article id is null");
        }

        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article", "articleId", id));
        articleRepository.delete(article);
    }

}
