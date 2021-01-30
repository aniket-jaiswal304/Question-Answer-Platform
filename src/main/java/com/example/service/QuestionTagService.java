package com.example.service;

import com.example.dao.QuestionTagsDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTagService {

    @Autowired
    QuestionTagsDaoI questionTagsDao;
}
