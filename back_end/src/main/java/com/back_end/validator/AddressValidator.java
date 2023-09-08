package com.back_end.validator;

import com.back_end.dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {

    public static List<String> validate(AddressDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Please provide the street");
            errors.add("Please provide the city");
            errors.add("Please provide the state");
            errors.add("Please provide the postal code");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getStreet())) {
            errors.add("Please provide the street");
        }

        if (!StringUtils.hasLength(dto.getCity())) {
            errors.add("Please provide the city");
        }

        if (!StringUtils.hasLength(dto.getState())) {
            errors.add("Please provide the state");
        }

        if (!StringUtils.hasLength(dto.getPostalCode())) {
            errors.add("Please provide the postal code");
        }
        return errors;
    }

}
