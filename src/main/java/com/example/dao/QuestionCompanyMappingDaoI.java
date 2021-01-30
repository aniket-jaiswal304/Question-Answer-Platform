package com.example.dao;

import com.example.entity.QuestionCompanyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionCompanyMappingDaoI extends JpaRepository<QuestionCompanyMapping, Integer> {
}
