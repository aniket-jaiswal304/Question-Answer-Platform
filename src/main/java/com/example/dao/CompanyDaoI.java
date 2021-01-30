package com.example.dao;

import com.example.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDaoI extends JpaRepository<Company, Integer> {
}
