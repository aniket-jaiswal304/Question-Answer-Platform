package com.example.company.service;

import com.example.company.model.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> getAllCompanies();

    public Company getCompany(int companyId);

    public void deleteCompany(int companyId);

    public int addCompany(Company company);

    public void updateCompany(Company company);
}
