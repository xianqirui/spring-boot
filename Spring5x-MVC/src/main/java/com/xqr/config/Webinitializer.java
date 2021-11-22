package com.xqr.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Webinitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //基于Java的配置类加载 Spring的应用上下文
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        //注册Mc配置信息
        ctx.register(MvcConfig.class);
        //设置 Servletcontext上下文信息
        ctx.setServletContext(servletContext);
        //配置转发器 Dispatcher
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        //设置映射路径
        servlet.addMapping("/");
        //启动实例化
        servlet.setLoadOnStartup(1);
    }

}
