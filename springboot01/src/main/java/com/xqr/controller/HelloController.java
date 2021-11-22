package com.xqr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("mgs","haohaohao");
        return "index";
    }
}
