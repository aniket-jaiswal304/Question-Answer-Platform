package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    @GetMapping(value = "/get-companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping(value = "/get-company/{companyId}")
    public Company getCompany(@PathVariable int companyId) {
        return companyService.getCompany(companyId);
    }

    @DeleteMapping(value = "/delete-company/{companyId}")
    public void deleteCompany(@PathVariable int companyId) {
        companyService.deleteCompany(companyId);
    }

    @PostMapping(value = "/add-company")
    public int createCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @PutMapping(value = "/update-company")
    public void updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
    }
}
