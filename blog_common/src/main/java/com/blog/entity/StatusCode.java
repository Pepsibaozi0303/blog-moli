package com.blog.entity;

/**
 * 返回码
 */
public class StatusCode {

    public static final int OK=0;//成功
    public static final int ERROR =-1;//失败
    public static final int LOGINERROR =2;//用户名或密码错误
    public static final int ACCESSERROR =3;//权限不足
    public static final int REMOTEERROR =4;//远程调用失败
    public static final int REPERROR =5;//重复操作

}
