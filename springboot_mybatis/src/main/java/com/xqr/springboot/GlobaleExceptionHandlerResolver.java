package com.xqr.springboot;

import com.xqr.springboot.exception.ParamsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//全局异常处理
@ControllerAdvice
public class GlobaleExceptionHandlerResolver {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> excpetion(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code",500);
        map.put("msg","系统异常请重试");
        //指定异常
        if(e instanceof ParamsException){
            ParamsException p=(ParamsException)e ;
            map.put("code",p.getCode());
            map.put("msg",p.getMsg());
        }
        return map;
    }
}
