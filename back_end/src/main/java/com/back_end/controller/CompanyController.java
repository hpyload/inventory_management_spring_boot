package com.back_end.controller;

import com.back_end.dto.CompanyDto;
import com.back_end.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.save(companyDto), HttpStatus.CREATED);
    }

    @GetMapping( "/{companyId}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable(value = "companyId") Long companyId) {
        return new ResponseEntity<>(companyService.findById(companyId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CompanyDto>> getAllDepartment() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping( "/{companyId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable(value = "companyId") Long companyId) {
        companyService.delete(companyId);
        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
    }

}
