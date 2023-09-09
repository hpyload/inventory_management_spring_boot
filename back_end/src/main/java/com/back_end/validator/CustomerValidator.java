package com.back_end.validator;

import com.back_end.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Please provide the first name");
            errors.add("Please provide the last name");
            errors.add("Please provide the email");
            errors.add("Please provide the phone number");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getFirstName())) {
            errors.add("Please provide the first name");
        }

        if (!StringUtils.hasLength(dto.getLastName())) {
            errors.add("Please provide the last name");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Please provide the email");
        }

        if (!StringUtils.hasLength(dto.getPhone())) {
            errors.add("Please provide the phone number");
        }

        errors.addAll(AddressValidator.validate(dto.getAddress()));

        return errors;
    }
}
