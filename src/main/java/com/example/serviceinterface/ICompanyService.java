package com.example.serviceinterface;

import com.example.model.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getAllCompanies();

    Company getCompany(int companyId);

    void deleteCompany(int companyId);

    Company createCompany(Company company);

    Company updateCompany(Company company);
}
