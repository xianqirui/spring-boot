package com.xqr.config;

import com.xqr.annonation.MyCompScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@MyCompScan("com.xqr")
//PropertySource声明资源文件
@PropertySource(value = {"classpath:jdbc.properties"})
public class IocConfig04 {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("$jdbc.username")
    private String name;
    @Value("jdbc.passwd")
    private String pwd;

    public void test(){
        System.out.println(driver+" "+url+" "+name+" "+pwd);
    }
}
