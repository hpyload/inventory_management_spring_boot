package com.back_end.service.Impl;

import com.back_end.dto.SaleDto;
import com.back_end.entity.Sale;
import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.SaleRepository;
import com.back_end.service.SaleService;
import com.back_end.validator.SaleValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private Mapper<Sale, SaleDto> mapper;

    @Override
    public SaleDto save(SaleDto saleDto) {
        List<String> errors = new ArrayList<>();

        String code = saleDto.getCode();

        Sale saleByCode = saleRepository.findSaleByCode(code);

        if (saleByCode != null) {
            errors.add("Duplicate code of sale");
        }

        errors.addAll(SaleValidator.validate(saleDto));

        if (!errors.isEmpty()) {
            log.error("Sale is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }
        Sale customer = saleRepository.save(mapper.mapToEntity(saleDto, Sale.class));
        return mapper.mapToDto(customer, SaleDto.class);
    }

    @Override
    public SaleDto findById(Long id) {
        if (id == null) {
            log.error("Sale id is null");
            throw new ResourceNotFoundException("Sale id is null");
        }

        Sale customer = saleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Sale", "customerId", id));
        return mapper.mapToDto(customer, SaleDto.class);
    }

    @Override
    public List<SaleDto> findAll() {
        List<Sale> customers = saleRepository.findAll();
        return customers.stream().map(customer -> mapper.mapToDto(customer, SaleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Sale id is null");
            throw new ResourceNotFoundException("Sale id is null");
        }

        Sale customer = saleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Sale", "saleId", id));
        saleRepository.delete(customer);
    }
}
