package com.xqr.springboot.util;


import com.xqr.springboot.exception.ParamsException;

public class AssertUtil {

    public static void isTrue(boolean flag,String msg){
        if (flag){
            throw new ParamsException(msg);
        }
    }
}
