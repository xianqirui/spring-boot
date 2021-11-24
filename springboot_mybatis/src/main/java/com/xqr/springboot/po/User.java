package com.xqr.springboot.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/*
* 数据校验会抛出异常，被全局校验捕获
* */
//实现序列化
@ApiModel(value = "用户实体类")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id",example = "默认0")
    @NotBlank(message = "id不能为空")
    private Integer id;

    @ApiModelProperty(value = "用户姓名",example = "默认")
    @NotBlank(message = "用户姓名不能为空")
    private String userName;

    @ApiModelProperty(value = "用户密码",example = "1234")
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
