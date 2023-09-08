package com.back_end.dto;

import com.back_end.entity.SaleEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private Long id;

    private String code;

    private Instant saleDate;

    private String comment;

    private Long companyId;

    private List<SaleEntryDto> salesEntries;
}
