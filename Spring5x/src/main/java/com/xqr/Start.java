package com.xqr;

import com.xqr.config.IocConfig;
import com.xqr.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        //基于java配置类得到上下文环境
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(IocConfig.class);
        //得到指定bean对象
        UserService userService = ac.getBean(UserService.class);
        userService.test();
    }
}
