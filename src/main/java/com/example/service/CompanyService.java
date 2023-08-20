package com.example.service;

import com.example.daointerface.ICompanyDao;
import com.example.model.Company;
import com.example.serviceinterface.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Inject
    @Named(value = "companyDao")
    ICompanyDao companyDao;

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.findAll();
    }

    @Override
    public Company getCompany(int companyId) {
        Optional<Company> companyOptional = companyDao.findById(companyId);
        return companyOptional.orElse(null);
    }

    @Override
    public void deleteCompany(int companyId) {
        companyDao.deleteById(companyId);
    }

    @Override
    public Company createCompany(Company company) {
        try {
            return companyDao.save(company);
        } catch (Exception exception) {
            return null;
        }

    }

    @Override
    public Company updateCompany(Company company) {
        try {
            return companyDao.save(company);
        } catch (Exception exception) {
            return null;
        }
    }
}