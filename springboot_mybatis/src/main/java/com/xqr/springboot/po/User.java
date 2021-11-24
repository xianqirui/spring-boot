package com.xqr.springboot.po;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/*
* 数据校验会抛出异常，被全局校验捕获
* */
//实现序列化
public class User implements Serializable {
    private Integer id;

    @NotBlank(message = "用户姓名不能为空")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    @Length(min = 4,max = 10,message = "用户密码长度在4——10之间")
    private String userPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
