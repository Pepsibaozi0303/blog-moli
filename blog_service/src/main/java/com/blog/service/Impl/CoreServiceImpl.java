package com.blog.service.Impl;

import com.blog.dao.CoreArticlesDao;
import com.blog.dao.CoreSortsDao;
import com.blog.pojo.Articles;
import com.blog.pojo.Sorts;
import com.blog.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: k1181521
 * @Date: 2020/12/25
 */
@Service
public class CoreServiceImpl implements CoreService {
    private static final Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);

    @Autowired
    private CoreArticlesDao coreArticlesDao;

    @Autowired
    private CoreSortsDao coreSortsDao;

    @Override
    public void publish(Articles articles) {

    }

    @Override
    public void draft(Articles articles) {

    }

    @Override
    public List<Articles> homePage() {
        List<Articles> articles = coreArticlesDao.selectHotArticle();
        return articles;
    }

    @Override
    public Articles microBlog(String article_id){
        Articles articles = coreArticlesDao.selectByPrimaryKey(article_id);
        articles.setArticle_views(articles.getArticle_views()+1);
        logger.info("博文被阅读 article_id:{}",article_id);
        return articles;
    }

    @Override
    public List<Sorts> sorts() {
        List<Sorts> sorts = coreSortsDao.selectAll();
        return sorts;
    }
}
