package com.blog.service.Impl;

import com.blog.pojo.Articles;
import com.blog.service.MdService;
import com.blog.utils.Md2xParseUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:baozi
 * @Date:2020-12-21 22:02
 */
@Service
public class MdServiceImpl implements MdService {

    @Override
    public void upload(MultipartFile file,String username) {
        if (file == null) {
            throw new RuntimeException("上传文件为空，请重新上传");
        }
        String name = file.getName();
        Map<String, List<String>> strMap = Md2xParseUtil.parse(name);
        String title = strMap.get("title").get(0);
        String content = strMap.get("content").get(0);
        long currentTimeMillis = System.currentTimeMillis();
        Articles articles = new Articles();
        articles.setArticle_title(title);
        articles.setArticle_content(content);
        articles.setArticle_date(new Date(currentTimeMillis));

    }

    @Override
    public void download() {

    }
}
