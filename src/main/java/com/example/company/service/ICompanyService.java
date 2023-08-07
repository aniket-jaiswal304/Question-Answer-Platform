package com.example.company.service;

import com.example.company.model.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> getAllCompanies();

    public Company getCompany(int companyId);

    public boolean deleteCompany(int companyId);

    public Company addCompany(Company company);

    public Company updateCompany(Company company);
}
