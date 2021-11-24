package com.xqr.test.service;

import com.xqr.test.dao.UserDao;
import com.xqr.test.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public User selectUser(String userName){
        return userDao.selectid(userName);
    }
}
