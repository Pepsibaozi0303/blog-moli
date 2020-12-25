package com.blog.service;

import com.blog.pojo.User;

/**
 * @Author:baozi
 * @Date:2020-12-16 20:58
 */
public interface UserService {

    User login(String userName, String passWord);

    void register(User user);

    String selectByUserName(String userName);

    String show();

}
