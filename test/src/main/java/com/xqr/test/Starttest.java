package com.xqr.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xqr.test.dao")
public class Starttest {
    public static void main(String[] args) {
        SpringApplication.run(Starttest.class);
    }
}
