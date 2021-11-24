package com.xqr.springboot.query;

import java.io.Serializable;

//分页
public class UserQuery implements Serializable {
    private Integer pageNum=1;//当前第几页
    private Integer pageSize=10;//每页显示记录数
    //条件参数
    private String userName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
