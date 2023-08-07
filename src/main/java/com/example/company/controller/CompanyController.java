package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    @GetMapping(value = "/get-companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok().body(companyService.getAllCompanies());
    }

    @GetMapping(value = "/get-company/{companyId}")
    public ResponseEntity<Company> getCompany(@PathVariable int companyId) {
        if(companyId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Company company = companyService.getCompany(companyId);

        return ResponseEntity.ok().body(company);
    }

    @PostMapping(value = "/add-company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok().body(companyService.addCompany(company));
    }

    @DeleteMapping(value = "/delete-company/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable int companyId) {
        if(companyId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(companyService.deleteCompany(companyId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update-company")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        if(company.getCompanyId() <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        company = companyService.updateCompany(company);
        if(company != null)
            return ResponseEntity.ok().body(company);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
