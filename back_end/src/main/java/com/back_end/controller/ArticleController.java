package com.back_end.controller;

import com.back_end.dto.ArticleDto;
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

    @DeleteMapping( "/{articleId}")
    public ResponseEntity<String> deleteArticleById(@PathVariable(value = "articleId") Long articleId) {
        articleService.delete(articleId);
        return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK);
    }
    
}
