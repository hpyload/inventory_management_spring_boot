package com.back_end.validator;

import com.back_end.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<String>();

        if (dto == null) {
            errors.add("Please provide the Article ");
            errors.add("Please provide the Article designation");
            errors.add("Please provide the Article net unit price");
            errors.add("Please provide the Article tax rate");
            errors.add("Please provide the Article gross unit price");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Please provide the Article code");
        }

        if (!StringUtils.hasLength(dto.getDesignation())) {
            errors.add("Please provide the Article designation");
        }

        if (dto.getNetUnitPrice() == null) {
            errors.add("Please provide the Article net unit price");
        }

        if (dto.getTaxRate() == null) {
            errors.add("Please provide the Article tax rate");
        }

        if (dto.getGrossUnitPrice() == null) {
            errors.add("Please provide the Article gross unit price");
        }
        return errors;
    }

}
