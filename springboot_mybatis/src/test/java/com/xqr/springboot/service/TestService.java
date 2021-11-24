package com.xqr.springboot.service;

import com.xqr.springboot.Start;
import com.xqr.springboot.po.User;
import com.xqr.springboot.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={Start.class} )

public class TestService {
    @Resource
    private UserService userService;
    @Before
    public void bf(){
        System.out.println("单元测试开始");
    }
    @After
    public void after(){
        System.out.println("单元测试结束");
    }
    @Test//业务层测试
    public void testselectbyid(){
        User user = userService.findByid(1);
        System.out.println(user.toString());
    }


}
