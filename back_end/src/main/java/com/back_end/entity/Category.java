package com.back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private String code;

    private String designation;

    private Long companyId;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;

}
