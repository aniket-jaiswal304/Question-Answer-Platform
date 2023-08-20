package com.example.service;

import com.example.daointerface.IUserDao;
import com.example.serviceinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;
}
