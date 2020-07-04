package com.mooc.demo;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/**
 * 读取 JSON 数据演示类
 * @Author       LQ
 * @CreateDate   2020/7/4 11:09
 * @Version      1.0
 */
public class ReadJsonSample {
    public static void main(String[] args) throws IOException {
        createJsonByFile();
    }
    /**
     * 读取 JSON 数据
     * */
    public static void createJsonByFile() throws IOException {
        File file = new File(ReadJsonSample.class.getResource("/wangxiaoer.json").getFile());

        String content = FileUtils.readFileToString(file,"UTF-8");

        JSONObject jsonObject = new JSONObject(content);

        System.out.println("姓名："+jsonObject.getString("name"));
        System.out.println("年龄："+jsonObject.getDouble("age"));
        System.out.println("有没有女朋友？："+jsonObject.getBoolean("has_girlfriend"));

        JSONArray majorArray = jsonObject.getJSONArray("major");
        for (int i = 0 ; i < majorArray.length(); i++) {
            System.out.println("专业"+(i+1)+"："+majorArray.get(i));
        }

        // 判断属性的值是否为空
        String key = "nickname";
        if(!jsonObject.isNull(key)){
            System.out.println("昵称："+jsonObject.getDouble("nickname"));
        }
    }

}
