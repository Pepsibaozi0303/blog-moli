package com.blog.controller;

import com.blog.entity.Result;
import com.blog.entity.StatusCode;
import com.blog.service.MdService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: k1181521
 * @Date: 2020/12/22
 */

/**
 * md文件解析接口
 */
@RestController
@RequestMapping("/md")
public class MdController {
    @Autowired
    private MdService mdService;

    /**
     * md文件上传，发文
     * @param file 上传的md文件
     * @param username 发文的用户名
     * @return
     */
    @PostMapping("/upload/{username}")
    public Result upload(@RequestParam MultipartFile file, @PathVariable(required = true, name = "username")String username){
        try {
            mdService.upload(file,username);
            return new Result(StatusCode.OK,"文件上传成功");
        } catch (Exception e) {
            return new Result(StatusCode.ERROR,"文件上传失败");
        }
    }

}
