package com.blog.controller;

import com.blog.entity.Result;
import com.blog.entity.StatusCode;
import com.blog.pojo.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:baozi
 * @Date:2020-12-16 23:19
 */

/**
 * 用户接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login/{username}/{password}")
    public Result login(@PathVariable(required = true, name = "username") String username, @PathVariable(required = true, name = "password")String password) {
        if (username == null) {
            throw new RuntimeException("请输入用户名");
        }
        if (password == null) {
            throw new RuntimeException("请输入密码");
        }
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("登录成功");
            return new Result(StatusCode.OK, "登录成功");
        }
        System.out.println("登录成功");
        return new Result(StatusCode.ERROR, "用户名或密码错误");
    }


}
