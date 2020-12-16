package com.blog.service;

import com.blog.pojo.User;

/**
 * @Author:baozi
 * @Date:2020-12-16 20:58
 */
public interface LoginService {

    User login(String userName, String passWord);
}
