package com.blog.entity;

/**
 * 返回结果实体类
 */
public class Result<T> {

    private Integer code;//是否成功 0成功 -1失败
    private String message;//返回消息
    private T data;//返回数据

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = (T)data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.code = StatusCode.OK;
        this.message = "执行成功";
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
