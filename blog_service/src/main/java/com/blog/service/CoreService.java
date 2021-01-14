package com.blog.service;

import com.blog.pojo.Articles;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/** blog核心功能
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public interface CoreService {

    //发布
    void publish(Articles articles);

    //暂存
    void draft(Articles articles);

    //查看首页博文
    List<Articles> homePage();

    //查看博文
    Articles microBlog(String article_id);
}
