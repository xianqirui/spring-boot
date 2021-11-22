package com.xqr.config;

import com.xqr.dao.AccountDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xqr")
public class IocConfig2 {
    @Bean //将方法的返回值交给ioc管理类
    public AccountDao accountDao(){
        return new AccountDao();
    }
}
