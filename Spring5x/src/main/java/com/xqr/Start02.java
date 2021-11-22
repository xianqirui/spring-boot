package com.xqr;

import com.xqr.config.IocConfig2;
import com.xqr.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start02 {
    public static void main(String[] args) {
        //基于java配置类得到上下文环境
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(IocConfig2.class);
        //得到指定bean对象
       //得到配置类对象
        IocConfig2 iocConfig2 = ac.getBean(IocConfig2.class);
        IocConfig2 iocConfig20 = ac.getBean(IocConfig2.class);
        System.out.println(iocConfig2+"=="+iocConfig20);
        //调用方法，得到AccountDao对象
        AccountDao accountDao=iocConfig2.accountDao();
        AccountDao accountDao0=iocConfig2.accountDao();
        System.out.println(accountDao+"=="+accountDao0);

    }
}
