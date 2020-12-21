package com.blog.utils;


import top.touchface.md2x.Md2x;
import top.touchface.md2x.entity.Options;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public class Md2xParseUtil {
    private static Map<String, List<String>> mdStr;

    public static Map parse(String fileName) {
        String mdInfo = getStr(fileName);

        // 创建解析器对象
        Md2x md2x = new Md2x();
        parseMdInfo(mdInfo, md2x);
        postHandle(mdInfo);
        return mdStr;
    }

    private static void postHandle(String mdInfo) {
        String title = mdStr.get("level_1").get(0);
        mdStr.put("title",Arrays.asList(title));
        int titleLen = title.length();
        String content =mdInfo.substring(titleLen);
        mdStr.put("content",Arrays.asList(content));
    }

    public static Map parse(String fileName, Options option) {
        String mdInfo = getStr(fileName);

        // 创建解析器对象
        Md2x md2x = new Md2x(option);
        parseMdInfo(mdInfo, md2x);
        postHandle(mdInfo);
        return mdStr;
    }

    // 循环解析Markdown文本
    private static void parseMdInfo(String mdInfo, Md2x md2x) {
        int num = 1000;
        List<String> picStr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String currentline = md2x.parse(mdInfo);
            if (currentline != null && currentline.length() > 0) {
                if (currentline.startsWith("# ")){
                    mdStr.put("level_1", Arrays.asList(currentline));
                }
                if (currentline.startsWith("## ")){
                    mdStr.put("level_2",Arrays.asList(currentline));
                }
                if (currentline.startsWith("### ")){
                    mdStr.put("level_3",Arrays.asList(currentline));
                }
                if (currentline.startsWith("#### ")){
                    mdStr.put("level_4",Arrays.asList(currentline));
                }
                if (currentline.startsWith("##### ")){
                    mdStr.put("level_5",Arrays.asList(currentline));
                }
                if (currentline.startsWith("###### ")){
                    mdStr.put("level_6",Arrays.asList(currentline));
                }
                if (currentline.startsWith("![](")){
                    int index = currentline.lastIndexOf(")");
                    String substring = currentline.substring(4, index);
                    picStr.add(substring);
                }
            }
        }
        mdStr.put("picture",picStr);
    }

    private static String getStr(String name) {
        File file = new File(ClassLoader.getSystemResource(name).getFile());
        if (file.isFile() && file.exists()) {
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String line;
                StringBuilder sb = new StringBuilder();
                while (null != (line = bufferedReader.readLine())) {
                    sb.append(line).append("\n");
                }

                bufferedReader.close();
                return sb.toString();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            System.out.println("md2x:file not found!");
        }
        return null;
    }

}
