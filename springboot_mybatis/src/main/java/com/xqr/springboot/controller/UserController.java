package com.xqr.springboot.controller;


import com.xqr.springboot.po.User;
import com.xqr.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@Controller //可以视图，可以json
@RestController//返回json,可以不加@ResponseBody注解
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("user/{userName}")
    //@ResponseBody
    public User findUser(@PathVariable String userName){
    return userService.findUser(userName);
    }
}
