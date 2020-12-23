package com.blog.utils;


import org.springframework.web.multipart.MultipartFile;
import top.touchface.md2x.Md2x;
import top.touchface.md2x.entity.Options;

import java.io.*;
import java.util.*;

/**
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public class Md2xParseUtil {
    private static Map<String, List<String>> mdStr = new HashMap<>();

    public static Map<String, List<String>> parse(MultipartFile file) {
        String mdInfo = getStr(file);
        postHandle(mdInfo);
        return mdStr;
    }

    private static void postHandle(String mdInfo) {
        String title = mdStr.get("level_1").get(0);
        if (title == null) {
            mdStr.put("title", Arrays.asList("博客"));
        } else {
            mdStr.put("title", Arrays.asList(title));
        }
        int titleLen = title.length();
        String content = mdInfo.substring(titleLen);
        mdStr.put("content", Arrays.asList(content));
    }


    private static String getStr(MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                InputStream inputStream = file.getInputStream();
                InputStreamReader read = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(read);
                String currentline;
                boolean flag = false;
                StringBuilder articleBody = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                List<String> picStr = new ArrayList<>();
                while (null != (currentline = bufferedReader.readLine())) {
                    articleBody.append(currentline).append("\n");
                    //暂定一级标题为博文题目，并且题目不能超过100个字符
                    if (currentline.startsWith("# ") && currentline.length() <= 100) {
                        mdStr.put("level_1", Arrays.asList(currentline));
                        continue;
                    }
                    if (currentline.startsWith("## ")) {
                        mdStr.put("level_2", Arrays.asList(currentline));
                        continue;
                    }
                    if (currentline.startsWith("### ")) {
                        mdStr.put("level_3", Arrays.asList(currentline));
                        continue;
                    }
                    if (currentline.startsWith("#### ")) {
                        mdStr.put("level_4", Arrays.asList(currentline));
                        continue;
                    }
                    if (currentline.startsWith("##### ")) {
                        mdStr.put("level_5", Arrays.asList(currentline));
                        continue;
                    }
                    if (currentline.startsWith("###### ")) {
                        mdStr.put("level_6", Arrays.asList(currentline));
                        continue;
                    }
                    //图片
                    if (currentline.startsWith("![]")) {
                        int index = currentline.lastIndexOf(")");
                        if (index < 0) {
                            index = currentline.length();
                        }
                        String substring = currentline.substring(4, index);
                        picStr.add(substring);
                        continue;
                    }
                    //前言代码块
                    if (currentline.startsWith("```中文")) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        if (currentline.startsWith("```")) {
                            mdStr.put("perfaceStr", Arrays.asList(sb.toString()));
                            flag = false;
                            continue;
                        }
                        sb.append(currentline);
                    }
                    //正文解析

                }
                mdStr.put("picture", picStr);

                bufferedReader.close();
                return articleBody.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("md2x:file not found!");
        }
        return null;
    }

}
