package com.xqr.springboot.service;

import com.xqr.springboot.dao.UserMapper;
import com.xqr.springboot.po.User;
import com.xqr.springboot.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    //查询用户对象
    public User findUser(String userName){
        return userMapper.selectUser(userName);
    }

    //id查询
    public User findByid(Integer userId){
        return userMapper.selectbyid(userId);
    }

    //添加
    /*1.参数校验
    * */
    public void addUser(User user){
        //非空判断
        //StringUtils.isBlank(user.getUserName());
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户姓名不能为空");
        //判断用户密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不能为空");
        //通过用户名查询用户
        User temp=userMapper.selectUser(user.getUserName());
        //通过用户名判断用户是否为空
        AssertUtil.isTrue(temp!=null,"用户已存在，请重试");
        //执行添加操作
        //int num=userMapper.addUser(user);
        AssertUtil.isTrue(userMapper.addUser(user)<1,"添加用户失败");
    }

}
