package com.blog.controller;

import com.blog.entity.Result;
import com.blog.entity.StatusCode;
import com.blog.pojo.User;
import com.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:baozi
 * @Date:2020-12-16 23:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    //登录
    @RequestMapping("/login")
    public Result login(String username, String password) {
        if (username == null) {
            throw new RuntimeException("请输入用户名");
        }
        if (password == null) {
            throw new RuntimeException("请输入密码");
        }
        User user = loginService.login(username, password);
        if (user != null) {
            return new Result(true, StatusCode.OK, "登录成功");
        }
        return new Result(false, StatusCode.ERROR, "用户名或密码错误");
    }
}
