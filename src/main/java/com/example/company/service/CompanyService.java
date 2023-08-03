package com.example.company.service;

import com.example.company.dao.ICompanyDao;
import com.example.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyDao companyDao;

    public List<Company> getAllCompanies()
    {
        List<Company> companies = companyDao.findAll();

        return companies;
    }

    public Company getCompany(int companyId)
    {
        Optional<Company> companyOptional = companyDao.findById(companyId);
        Company company = companyOptional.get();

        return company;
    }

    public void deleteCompany(int companyId)
    {
        companyDao.deleteById(companyId);
    }

    public int addCompany(Company company)
    {
        companyDao.save(company);
        return company.getCompanyId();
    }

    public void updateCompany(Company company)
    {
        companyDao.save(company);
    }
}