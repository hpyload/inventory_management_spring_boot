package com.back_end.validator;

import com.back_end.dto.CompanyDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {

    public static List<String> validate(CompanyDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Please provide the company name");
            errors.add("Please provide the company description");
            errors.add("Please provide the company email");
            errors.add("Please provide the company phone number");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getName())) {
            errors.add("Please provide the company name");
        }

        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("Please provide the company description");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Please provide the company email");
        }

        if (!StringUtils.hasLength(dto.getPhone())) {
            errors.add("Please provide the company phone number");
        }
        return errors;
    }

}
