package com.blog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public interface MdService {

    //导入
    void upload(MultipartFile file,String username);

    //导出
    void download();
}
