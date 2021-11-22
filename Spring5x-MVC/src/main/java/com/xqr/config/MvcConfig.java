package com.xqr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xqr")
@EnableWebMvc//启用mvc环境
public class MvcConfig {
    @Bean//将方法的返回值交给ioc维护
    public InternalResourceViewResolver resourceViewResolver(){
        //得到视图解析器
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //设置视图解析器前缀
        internalResourceViewResolver.setPrefix("WEB-INF/jsp");
        //设置视图解析器后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
