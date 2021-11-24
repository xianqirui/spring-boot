package com.xqr.springboot.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

//分页
@ApiModel(value = "用户查询类")
public class UserQuery  {
    @ApiModelProperty(value = "当前页数")
    private Integer pageNum=1;//当前第几页
    @ApiModelProperty(value = "每页显示数量")
    private Integer pageSize=10;//每页显示记录数
    //条件参数
    @ApiModelProperty(value = "用户名称")
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
