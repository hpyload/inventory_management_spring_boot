package com.back_end.service.Impl;

import com.back_end.dto.CompanyDto;
import com.back_end.entity.Company;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.CompanyRepository;
import com.back_end.service.CompanyService;
import com.back_end.validator.CompanyValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private Mapper<Company, CompanyDto> mapper;

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        List<String> errors = new ArrayList<>();

        String name = companyDto.getName();

        Company companyByName = companyRepository.findByName(name);

        if (companyByName != null) {
            errors.add("Duplicate name of company");
        }

        errors.addAll(CompanyValidator.validate(companyDto));

        if (!errors.isEmpty()) {
            log.error("Company is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }

        Company company = companyRepository.save(mapper.mapToEntity(companyDto, Company.class));
        return mapper.mapToDto(company , CompanyDto.class);
    }

    @Override
    public CompanyDto findById(Long id) {
        if (id == null) {
            log.error("Company id is null");
            throw new ResourceNotFoundException("Company id is null");
        }

        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Company", "CompanyId", id));
        return mapper.mapToDto(company , CompanyDto.class);
    }

    @Override
    public List<CompanyDto> findAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> mapper.mapToDto(company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Company id is null");
            throw new ResourceNotFoundException("Company id is null");
        }

        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Company", "CompanyId", id));
        companyRepository.delete(company);
    }

}
