package com.xqr.springboot.util;


import com.xqr.springboot.exception.ParmsException;

public class AssertUtil {

    public static void isTrue(boolean flag,String msg){
        if (flag){
            throw new ParmsException(msg);
        }
    }
}
