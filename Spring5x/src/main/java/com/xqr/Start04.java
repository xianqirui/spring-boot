package com.xqr;

import com.xqr.config.IocConfig03;
import com.xqr.config.IocConfig04;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start04 {
    public static void main(String[] args) {
        //基于java配置类得到上下文环境
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(IocConfig04.class);
        //得到指定bean对象
        IocConfig04 iocConfig04 = ac.getBean(IocConfig04.class);
        iocConfig04.test();
    }
}
