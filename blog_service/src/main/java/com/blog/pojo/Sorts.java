package com.blog.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: k1181521
 * @Date: 2021/1/14
 */
@Table(name = "sorts")
public class Sorts {
    @Id
    private String sort_id;           //分类ID
    private String sort_name;        //分类名称
    private String sort_alias;        //分类别名
    private String sort_description;  //分类描述
    private String parent_sort_id;    //父分类ID

    public String getSort_id() {
        return sort_id;
    }

    public void setSort_id(String sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public String getSort_alias() {
        return sort_alias;
    }

    public void setSort_alias(String sort_alias) {
        this.sort_alias = sort_alias;
    }

    public String getSort_description() {
        return sort_description;
    }

    public void setSort_description(String sort_description) {
        this.sort_description = sort_description;
    }

    public String getParent_sort_id() {
        return parent_sort_id;
    }

    public void setParent_sort_id(String parent_sort_id) {
        this.parent_sort_id = parent_sort_id;
    }
}
