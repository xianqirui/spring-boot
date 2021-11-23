package com.xqr.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xqr.springboot.dao.UserMapper;
import com.xqr.springboot.po.User;
import com.xqr.springboot.query.UserQuery;
import com.xqr.springboot.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    //修改
    public void updateUser(User user){
        //判断用户id
        AssertUtil.isTrue(user.getId()==null,"用户数据异常");
        //非空判断
        //StringUtils.isBlank(user.getUserName());
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户姓名不能为空");
        //判断用户密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不能为空");
        //通过用户名查询用户
        User temp=userMapper.selectUser(user.getUserName());
        //通过用户名判断用户是否为空
        AssertUtil.isTrue(temp!=null&&!user.getId().equals(temp.getId()),"用户已存在，请重试");
        //int num=userMapper.addUser(user);
        AssertUtil.isTrue(userMapper.updateUser(user)<1,"修改用户失败");
    }

    public void delectUser(Integer id){
        //判断非空
        AssertUtil.isTrue(id==null||userMapper.selectbyid(id)==null,"删除记录不存在");
        //执行删除
        AssertUtil.isTrue(userMapper.delectUser(id)<1,"删除失败");
    }

    //分页
    public PageInfo<User> queryByName(UserQuery userQuery){
        //开启分页
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        //查询
        List<User> userList=userMapper.queryUser(userQuery);
        //分页
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }
}
