package com.blog.service.Impl;

import com.blog.dao.MdDao;
import com.blog.dao.UserDao;
import com.blog.pojo.Articles;
import com.blog.service.MdService;
import com.blog.utils.Md2xParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:baozi
 * @Date:2020-12-21 22:02
 */
@Service
public class MdServiceImpl implements MdService {
    private static final Logger logger = LoggerFactory.getLogger(MdServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private MdDao mdDao;

    @Override
    public void upload(MultipartFile file,String username) {
        if (file == null) {
            throw new RuntimeException("上传文件为空，请重新上传");
        }
        Map<String, List<String>> strMap = Md2xParseUtil.parse(file);
        String title = strMap.get("title").get(0);
        String content = strMap.get("content").get(0);
        long currentTimeMillis = System.currentTimeMillis();
        Articles articles = new Articles();
        try {
            String userId = userDao.selectByUserName(username);
            articles.setUser_id(userId);
            articles.setArticle_title(title);
            articles.setArticle_content(content);
            articles.setArticle_date(new Date(currentTimeMillis));
            articles.setArticle_views(0);
            articles.setArticle_comment_count(0);
            articles.setArticle_like_count(0);
            mdDao.insertSelective(articles);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("MdServiceImpl 文件上传错误，username={},e={}",username,e);
            throw new RuntimeException("文件上传错误");
        }

    }

    @Override
    public void download() {

    }
}
