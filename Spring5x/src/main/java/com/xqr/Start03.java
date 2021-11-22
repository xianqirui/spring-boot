package com.xqr;

import com.xqr.config.IocConfig03;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start03 {
    public static void main(String[] args) {
        //基于java配置类得到上下文环境
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(IocConfig03.class);
        //得到指定bean对象
        IocConfig03 iocConfig03 = ac.getBean(IocConfig03.class);
        iocConfig03.test();
    }
}
