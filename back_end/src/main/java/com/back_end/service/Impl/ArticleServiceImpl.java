package com.back_end.service.Impl;

import com.back_end.dto.*;
import com.back_end.entity.Article;
import com.back_end.entity.CustomerOrderLine;
import com.back_end.entity.SaleEntry;
import com.back_end.entity.SupplierOrderLine;
import com.back_end.exception.InvalidOperationException;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.*;
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
    private SaleEntryRepository saleEntryRepository;
    private CustomerOrderLineRepository customerOrderLineRepository;
    private SupplierOrderLineRepository supplierOrderLineRepository;
    private Mapper<Article, ArticleDto> articleMapper;
    private Mapper<SaleEntry, SaleEntryDto> saleEntryMapper;
    private Mapper<CustomerOrderLine, CustomerOrderLineDto> customerOrderLineMapper;
    private Mapper<SupplierOrderLine, SupplierOrderLineDto> supplierOrderLineMapper;


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

        Article article = articleRepository.save(articleMapper.mapToEntity(articleDto, Article.class));

        return articleMapper.mapToDto(article, ArticleDto.class);
    }

    @Override
    public ArticleDto findById(Long id) {

        if (id == null) {
            log.error("Article id is null");
            throw new ResourceNotFoundException("Article id is null");
        }

        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article", "articleId", id));

        return articleMapper.mapToDto(article, ArticleDto.class);
    }

    @Override
    public List<ArticleDto> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(article -> articleMapper.mapToDto(article, ArticleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllByCategoryId(Long categoryId) {
        List<Article> articles = articleRepository.findAllByCategoryId(categoryId);
        return articles.stream()
                .map(article -> articleMapper.mapToDto(article, ArticleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleEntryDto> findSaleHistory(Long articleId) {
        List<SaleEntry> saleEntries = saleEntryRepository.findAllByArticleId(articleId);
                return saleEntries.stream()
                        .map(saleEntry -> saleEntryMapper.mapToDto(saleEntry, SaleEntryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerOrderLineDto> findCustomerOrderHistory(Long articleId) {
        List<CustomerOrderLine> customerOrderLines = customerOrderLineRepository.findAllByArticleId(articleId);
        return customerOrderLines.stream()
                .map(customerOrderLine -> customerOrderLineMapper.mapToDto(customerOrderLine, CustomerOrderLineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierOrderLineDto> findSupplierOrderHistory(Long articleId) {
        List<SupplierOrderLine> supplierOrderLines = supplierOrderLineRepository.findAllByArticleId(articleId);
        return supplierOrderLines.stream()
                .map(supplierOrderLine -> supplierOrderLineMapper.mapToDto(supplierOrderLine, SupplierOrderLineDto.class))
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

        List<CustomerOrderLine> customerOrderLines = customerOrderLineRepository.findAllByArticleId(id);
        if (!customerOrderLines.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete an article that has already been used in customer orders");
        }

        List<SupplierOrderLine> supplierOrderLines = supplierOrderLineRepository.findAllByArticleId(id);
        if (!supplierOrderLines.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete an article that has already been used in supplier orders");
        }

        List<SaleEntry> saleEntries = saleEntryRepository.findAllByArticleId(id);
        if (!saleEntries.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete an article that has already been used in sales");
        }

        articleRepository.delete(article);
    }

}
