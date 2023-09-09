package com.back_end.validator;

import com.back_end.dto.SaleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleValidator {

    public static List<String> validate(SaleDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Please provide the sale code");
            errors.add("Please provide the sale date");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Please provide the sale code");
        }

        if (dto.getSaleDate() == null) {
            errors.add("Please provide the last name");
        }

        return errors;
    }
}
