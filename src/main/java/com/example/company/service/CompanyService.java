package com.example.company.service;

import com.example.company.dao.ICompanyDao;
import com.example.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyDao companyDao;

    public List<Company> getAllCompanies()
    {
        List<Company> companies;
        companies = companyDao.findAll();

        return companies;
    }

    public Company getCompany(int companyId)
    {
        Optional<Company> companyOptional = companyDao.findById(companyId);
        return companyOptional.orElse(null);
    }

    public boolean deleteCompany(int companyId)
    {
        if(companyDao.findById(companyId).isPresent()) {
            companyDao.deleteById(companyId);
            return true;
        }

        return false;
    }

    public Company addCompany(Company company)
    {
        return companyDao.save(company);
    }

    public Company updateCompany(Company company)
    {
        if(companyDao.findById(company.getCompanyId()).isPresent()) {
            return companyDao.save(company);
        }

        return null;
    }
}