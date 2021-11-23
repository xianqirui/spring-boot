package com.xqr.springboot.dao;

import com.xqr.springboot.po.User;

public interface UserMapper {

    //查询.通过用户名
    public User selectUser(String userName);
}
