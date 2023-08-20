package com.example.service;

import com.example.daointerface.QuestionCompanyMappingDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionCompanyMappingService {

    @Autowired
    QuestionCompanyMappingDaoI questionCompanyMappingDao;
}
