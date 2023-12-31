package com.back_end.repository;

import com.back_end.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findArticleByCode(String articleCode);

    List<Article> findAllByCategoryId(Long categoryId);

}
