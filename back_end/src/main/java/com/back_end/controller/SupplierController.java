package com.back_end.controller;

import com.back_end.dto.SupplierDto;
import com.back_end.service.CustomerService;
import com.back_end.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto) {
        return new ResponseEntity<>(supplierService.save(supplierDto), HttpStatus.CREATED);
    }

    @GetMapping( "/{supplierId}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable(value = "supplierId") Long supplierId) {
        return new ResponseEntity<>(supplierService.findById(supplierId),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping( "/{supplierId}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable(value = "supplierId") Long supplierId) {
        supplierService.delete(supplierId);
        return new ResponseEntity<>("Supplier deleted successfully", HttpStatus.OK);
    }

}
