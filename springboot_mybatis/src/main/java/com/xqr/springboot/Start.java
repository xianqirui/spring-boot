package com.xqr.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xqr.springboot.dao")//扫描接口
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}
