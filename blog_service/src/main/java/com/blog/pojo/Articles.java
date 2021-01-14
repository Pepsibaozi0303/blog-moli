package com.blog.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: k1181521
 * @Date: 2020/12/21
 */
@Table(name = "articles")
public class Articles implements Serializable {
    @Id
    private String article_id;  //博文ID
    private String user_id;  //发表用户ID
    private String article_title;  //博文标题
    private String article_content;  //博文内容
    private Integer article_views;  //浏览量
    private Integer article_comment_count;  //评论总数
    private Date article_date;  //发表时间
    private Integer article_like_count;  //点心数（喜欢数）
    private Integer is_delete;  //物理删除
    private String article_introduction;  //博文前言

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getArticle_views() {
        return article_views;
    }

    public void setArticle_views(Integer article_views) {
        this.article_views = article_views;
    }

    public Integer getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(Integer article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public Date getArticle_date() {
        return article_date;
    }

    public void setArticle_date(Date article_date) {
        this.article_date = article_date;
    }

    public Integer getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(Integer article_like_count) {
        this.article_like_count = article_like_count;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String getArticle_introduction() {
        return article_introduction;
    }

    public void setArticle_introduction(String article_introduction) {
        this.article_introduction = article_introduction;
    }
}
