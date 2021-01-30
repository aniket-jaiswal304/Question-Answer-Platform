package com.example.service;

import com.example.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDaoI userDao;
}
