package com.back_end.controller;

import com.back_end.dto.ArticleDto;
import com.back_end.dto.CustomerOrderLineDto;
import com.back_end.dto.SaleEntryDto;
import com.back_end.dto.SupplierOrderLineDto;
import com.back_end.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/articles")
public class ArticleController {

    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.save(articleDto), HttpStatus.CREATED);
    }

    @GetMapping( "/{articleId}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable(value = "articleId") Long articleId) {
        return new ResponseEntity<>(articleService.findById(articleId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @GetMapping( "customer-order-history/{articleId}")
    public ResponseEntity<List<CustomerOrderLineDto>> getCustomerOrderHistory(@PathVariable(value = "articleId")Long articleId) {
        return new ResponseEntity<>(articleService.findCustomerOrderHistory(articleId), HttpStatus.OK);
    }

    @GetMapping( "supplier-order-history/{articleId}")
    public ResponseEntity<List<SupplierOrderLineDto>> getSupplierOrderHistory(@PathVariable(value = "articleId")Long articleId) {
        return new ResponseEntity<>(articleService.findSupplierOrderHistory(articleId), HttpStatus.OK);
    }

    @GetMapping( "sale-history/{articleId}")
    public ResponseEntity<List<SaleEntryDto>> getSaleHistory(@PathVariable(value = "articleId")Long articleId) {
        return new ResponseEntity<>(articleService.findSaleHistory(articleId), HttpStatus.OK);
    }

    @DeleteMapping( "/{articleId}")
    public ResponseEntity<String> deleteArticleById(@PathVariable(value = "articleId") Long articleId) {
        articleService.delete(articleId);
        return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK);
    }
    
}
