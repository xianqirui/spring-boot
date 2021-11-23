package com.xqr.springboot.exception;

public class ParmsException extends RuntimeException {
    private Integer code=500;
    private String msg="参数异常";

    public ParmsException() {
        super("参数异常!");
    }
    public ParmsException(String msg) {
        super(msg);
        this.msg=msg;
    }
    public ParmsException(Integer code) {
        super("参数异常!");
        this.code=code;
    }
    public ParmsException(Integer code,String msg) {
        super(msg);
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode(){
        return code;
    }
    public void setCode(Integer code){
        this.code=code;
    }
    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
