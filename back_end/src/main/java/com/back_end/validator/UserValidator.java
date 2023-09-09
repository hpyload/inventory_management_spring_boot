package com.back_end.validator;

import com.back_end.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Please provide the user's first name");
            errors.add("Please provide the user's last name");
            errors.add("Please provide the user's email");
            errors.add("Please provide the username");
            errors.add("Please provide the user's password");
            errors.add("Please provide the user's address");

            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getFirstName())) {
            errors.add("Please provide the user's first name");
        }

        if (!StringUtils.hasLength(dto.getLastName())) {
            errors.add("Please provide the user's last name");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Please provide the user's email");
        }

        if (!StringUtils.hasLength(dto.getUsername())) {
            errors.add("Please provide the username");
        }

        if (!StringUtils.hasLength(dto.getPassword())) {
            errors.add("Please provide the user's password");
        }

        if (dto.getBirthdate() == null) {
            errors.add("Please provide the user's birthdate");
        }
        errors.addAll(AddressValidator.validate(dto.getAddress()));

        return errors;
    }
}
