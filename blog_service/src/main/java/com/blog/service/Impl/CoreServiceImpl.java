package com.blog.service.Impl;

import com.blog.dao.CoreDao;
import com.blog.pojo.Articles;
import com.blog.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: k1181521
 * @Date: 2020/12/25
 */
@Service
public class CoreServiceImpl implements CoreService {

    @Autowired
    private CoreDao coreDao;

    @Override
    public void publish(Articles articles) {

    }

    @Override
    public void draft(Articles articles) {

    }

    @Override
    public List<Articles> homePage() {
        List<Articles> articles = coreDao.selectHotArticle();
        return articles;
    }

    @Override
    public Articles microBlog(String article_id){
        Articles articles = coreDao.selectByPrimaryKey(article_id);
        articles.setArticle_views(articles.getArticle_views()+1);
        return articles;
    }
}
