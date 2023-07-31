package com.example.company.service;

import com.example.company.model.Company;
import com.example.model.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyDaoI companyDao;

    public List<CompanyInfo> retrieveAllCompanies()
    {
        List<Company> companies = companyDao.findAll();

        List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();

        for (Company company : companies)
        {
            CompanyInfo companyInfo = new CompanyInfo(company.getCompanyId(), company.getCompanyName());
            companyInfoList.add(companyInfo);
        }
        return companyInfoList;
    }

    public CompanyInfo retrieveCompany(int companyId)
    {
        Optional<Company> companyOptional = companyDao.findById(companyId);
        Company company = companyOptional.get();

        return new CompanyInfo(company.getCompanyId(), company.getCompanyName());
    }

    public void deleteCompany(int companyId)
    {
        companyDao.deleteById(companyId);
    }

    public int createCompany(CompanyInfo companyInfo)
    {
        Company company = new Company(companyInfo.getCompanyId(), companyInfo.getCompanyName());
        companyDao.save(company);
        return company.getCompanyId();
    }

    public void updateCompany(int companyId, CompanyInfo companyInfo)
    {
        Company company = new Company(companyInfo.getCompanyId(), companyInfo.getCompanyName());
        company.setCompanyId(companyId);
        companyDao.save(company);
    }
}