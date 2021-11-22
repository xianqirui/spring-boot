package com.xqr.annonation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
声明自定义组合注解
1.定义注解
2.给注解设置元注解
3.将需要组合的注解的属性覆盖
*/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
public @interface MyCompScan {
    String[] value() default {};
}
