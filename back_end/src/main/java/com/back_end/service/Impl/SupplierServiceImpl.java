package com.back_end.service.Impl;

import com.back_end.dto.SupplierDto;
import com.back_end.entity.Supplier;
import com.back_end.exception.InvalidResourceException;
import com.back_end.mapper.Mapper;
import com.back_end.repository.SupplierRepository;
import com.back_end.service.SupplierService;
import com.back_end.validator.SupplierValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;
    private Mapper<Supplier, SupplierDto> mapper;

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = new ArrayList<>();

        String email = supplierDto.getEmail();

        Supplier supplierByEmail = supplierRepository.findSupplierByEmail(email);

        if (supplierByEmail != null) {
            errors.add("Duplicate email of supplier");
        }

        errors.addAll(SupplierValidator.validate(supplierDto));

        if (!errors.isEmpty()) {
            log.error("Supplier is not valid {}", errors);
            throw new InvalidResourceException("Invalid resource exception", errors);
        }
        Supplier supplier = supplierRepository.save(mapper.mapToEntity(supplierDto, Supplier.class));
        return mapper.mapToDto(supplier, SupplierDto.class);
    }

    @Override
    public SupplierDto findById(Long id) {
        return null;
    }

    @Override
    public List<SupplierDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
