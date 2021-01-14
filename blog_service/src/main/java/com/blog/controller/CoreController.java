package com.blog.controller;

import com.blog.entity.Result;
import com.blog.entity.StatusCode;
import com.blog.pojo.Articles;
import com.blog.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: k1181521
 * @Date: 2020/12/25
 */

/**
 * 核心功能
 */
@RestController
@RequestMapping("/core")
public class CoreController {
    @Autowired
    private CoreService coreService;

    /**
     * 查询热门信息（首页使用）
     * @return 热门博文信息10条
     */
    @GetMapping("/home")
    public Result homePage(){
        try {
            List<Articles> articles = coreService.homePage();
            return new Result(StatusCode.OK,"热门博文查询成功",articles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,"后台异常");
        }

    }

    /**
     *查看博文
     * @param article_id 博文id
     * @return
     */
    @GetMapping("/views/{article_id}")
    public Result microBlog(@PathVariable(required = true) String article_id){
        try {
            Articles articles = coreService.microBlog(article_id);
            return new Result(StatusCode.OK,"热门博文查询成功",articles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,"后台异常");
        }

    }
}
