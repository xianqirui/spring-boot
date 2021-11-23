package com.xqr.springboot.service;

import com.xqr.springboot.dao.UserMapper;
import com.xqr.springboot.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    //查询用户对象
    public User findUser(String userName){
        return userMapper.selectUser(userName);
    }

}
