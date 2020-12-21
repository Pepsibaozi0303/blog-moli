package com.blog.service.Impl;

import com.blog.dao.UserDao;
import com.blog.pojo.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:baozi
 * @Date:2020-12-16 20:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String passWord) {
        return userDao.login(userName, passWord);
    }

    @Override
    public void register(User user) {

    }

    @Override
    public String selectByUserName(String userName) {
        String userId = userDao.selectByUserName(userName);
        return userId;
    }
}
