package com.back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    private String code;

    private Instant saleDate;

    private String comment;

    private Long companyId;

    @OneToMany(mappedBy = "sale")
    private List<SaleEntry> salesEntries;

}
