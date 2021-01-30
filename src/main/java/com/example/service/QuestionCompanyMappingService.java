package com.example.service;

import com.example.dao.QuestionCompanyMappingDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionCompanyMappingService {

    @Autowired
    QuestionCompanyMappingDaoI questionCompanyMappingDao;
}
