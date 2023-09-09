package com.back_end.validator;

import com.back_end.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto dto) {
        List<String> errors = new ArrayList<String>();

        if (dto == null || !StringUtils.hasLength(dto.getCode())) {
            errors.add("Please provide the category code");
        }
        return errors;
    }
}
