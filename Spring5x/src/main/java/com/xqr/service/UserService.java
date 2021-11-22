package com.xqr.service;

import com.xqr.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void test(){
        System.out.println("UserService...");
        userDao.test();
    }
}
