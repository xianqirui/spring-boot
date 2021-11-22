package com.xqr;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 设置banner图标，在banner文件中按
* 设置图标关闭
* */
@SpringBootApplication
public class Starter {
    //使用日志
    //private static Logger logger= LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        //SpringApplication.run(Starter.class);
        //打印日志
        //logger.error("项目正在启动");
        SpringApplication springApplication=new SpringApplication(Starter.class);
        //设置图标关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动项目
        springApplication.run();

    }
}
