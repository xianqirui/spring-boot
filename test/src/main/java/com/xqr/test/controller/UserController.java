package com.xqr.test.controller;

import com.xqr.test.po.User;
import com.xqr.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("select")
    public ModelAndView select(String userName){
        User user=userService.selectUser(userName);
        ModelAndView mv=new ModelAndView();
        mv.addObject("id",user.getId());
        mv.addObject("pwd",user.getUserPwd());
        mv.setViewName("show");
        return mv;
    }
}
