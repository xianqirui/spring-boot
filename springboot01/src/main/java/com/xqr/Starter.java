package com.xqr;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 设置banner图标，在banner文件中按
* 设置图标关闭
* */
@SpringBootApplication
public class Starter {
    public static void main(String[] args) {
        //SpringApplication.run(Starter.class);

        SpringApplication springApplication=new SpringApplication(Starter.class);
        //设置图标关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动项目
        springApplication.run();

    }
}
