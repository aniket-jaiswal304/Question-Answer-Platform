package com.example.daointerface;

import com.example.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyDao extends JpaRepository<Company, Integer> {
}
