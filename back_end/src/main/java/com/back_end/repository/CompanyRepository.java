package com.back_end.repository;

import com.back_end.dto.CompanyDto;
import com.back_end.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

}
