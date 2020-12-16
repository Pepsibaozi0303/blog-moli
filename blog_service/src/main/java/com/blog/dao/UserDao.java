package com.blog.dao;

import com.blog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author:baozi
 * @Date:2020-12-16 21:02
 */
public interface UserDao extends Mapper<User> {

    @Select("SELECT * FROM USER WHERE user_name = #{userName} AND pass_word = #{passWord}")
    User login(@Param("userName") String userName, @Param("passWord") String passWord);
}
