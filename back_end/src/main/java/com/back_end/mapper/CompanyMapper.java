package com.back_end.mapper;

import com.back_end.dto.CompanyDto;
import com.back_end.entity.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    private final ModelMapper modelMapper;

    public CompanyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CompanyDto mapToDto(Company article) {
        return modelMapper.map(article, CompanyDto.class);
    }

    public Company mapToEntity(CompanyDto articleDto) {
        return modelMapper.map(articleDto, Company.class);
    }
}
