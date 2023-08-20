package com.example.controller;

import com.example.model.Company;
import com.example.serviceinterface.ICompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Inject
    @Named(value = "companyService")
    ICompanyService companyService;

    @GetMapping(value = "/get-companies", produces = "application/json")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-company/{companyId}", produces = "application/json")
    public ResponseEntity<Company> getCompany(@PathVariable int companyId) {
        if (companyId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Company company = companyService.getCompany(companyId);

        if (company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/create-company", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        if (company.getCompanyId() != 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        company = companyService.createCompany(company);

        if (company != null)
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "/delete-company/{companyId}", produces = "application/json")
    public ResponseEntity deleteCompany(@PathVariable int companyId) {
        if (companyId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(companyService.getCompany(companyId) != null) {
            companyService.deleteCompany(companyId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping(value = "/update-company", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        if (company.getCompanyId() <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(companyService.getCompany(company.getCompanyId()) != null) {
            company = companyService.updateCompany(company);

            if (company != null)
                return new ResponseEntity<>(company, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}