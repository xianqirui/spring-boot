package com.xqr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.xqr")
//PropertySource声明资源文件
@PropertySource(value = {"classpath:jdbc.properties"})
public class IocConfig03 {
    private String driver;
    private String url;
    private String name;
    private String pwd;

    public void test(){
        System.out.println(driver+" "+url+" "+name+" "+pwd);
    }
}
