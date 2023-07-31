package com.example.company.dao;

import com.example.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDaoI extends JpaRepository<Company, Integer> {
}