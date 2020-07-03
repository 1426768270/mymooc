package com.mymooc.sso.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http工具类
 * @Author       LQ
 * @CreateDate   2020/7/3 19:15
 * @Version      1.0
 */
public class HttpUtil {

    public static  ResMessage doGet(String url,String cookieName,String cookieValue){
        ResMessage resMessage = new ResMessage();
        HttpURLConnection httpURLConnection = null;
        URL targetUrl = null;
        try {
            targetUrl = new URL(url+"?cookieName="+cookieName+"&cookieValue="+cookieValue);
            httpURLConnection = (HttpURLConnection) targetUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while ((temp=br.readLine())!=null){
                sb.append(temp);
            }

            br.close();
            isr.close();
            in.close();
            JSONObject resultJson = JSONObject.parseObject(sb.toString());
            resMessage.setRespCode(resultJson.getString("respCode"));
            resMessage.setRespMsg(resultJson.getString("respMsg"));
            return resMessage;
        }catch (Exception e){
            resMessage.setRespCode("500");
            resMessage.setRespMsg("Cookie校验请求失败");
            return resMessage;
        }finally {
            if (httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
        }

    }
}
