package com.xqr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//声明配置类相当于配置
@ComponentScan("com.xqr")//扫描起，扫描指定包下的注解
public class IocConfig {
}
