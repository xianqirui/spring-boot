package com.xqr.springboot.dao;

import com.xqr.springboot.po.User;
import com.xqr.springboot.query.UserQuery;

import java.util.List;

public interface UserMapper {

    //查询.通过用户名
    public User selectUser(String userName);
    //通过id查询对象
    public User selectbyid(Integer userId);
    //添加用户，返回受影响的行数
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除
    public int delectUser(Integer id);

    //分页查询
    List<User> queryUser(UserQuery userQuery);
}
