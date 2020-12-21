package com.blog;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.File;

/**
 * @Author:baozi
 * @Date:2020-12-16 21:01
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.blog.dao"})
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class);
        japidocs();

    }
    //接口文档
    public static void japidocs(){
        DocsConfig config = new DocsConfig();
        config.setProjectPath(new File("").getAbsolutePath()); // 项目根目录
        config.setProjectName("blog-moli"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath(new File("doc").getAbsolutePath()); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
