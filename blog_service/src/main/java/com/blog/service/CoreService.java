package com.blog.service;

import com.blog.pojo.Articles;
import org.springframework.web.multipart.MultipartFile;

/** blog核心功能
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public interface CoreService {

    //发布
    void publish(Articles articles);

    //暂存
    void draft(Articles articles);
}