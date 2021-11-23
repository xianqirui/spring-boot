package com.xqr.springboot.dao;

import com.xqr.springboot.po.User;

public interface UserMapper {

    //查询.通过用户名
    public User selectUser(String userName);
    //通过id查询对象
    public User selectbyid(Integer userId);
    //添加用户，返回受影响的行数
    int addUser(User user);
}
