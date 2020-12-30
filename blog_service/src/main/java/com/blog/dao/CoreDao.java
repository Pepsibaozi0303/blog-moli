package com.blog.dao;

import com.blog.pojo.Articles;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: k1181521
 * @Date: 2020/12/25
 */
public interface CoreDao extends Mapper<Articles> {

    @Select("SELECT * from articles ORDER BY article_views desc LIMIT 10;")
    List<Articles> selectHotArticle();
}
