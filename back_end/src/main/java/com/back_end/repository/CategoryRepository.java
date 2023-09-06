package com.back_end.repository;

import com.back_end.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByCode(String categoryCode);

}
