package com.mymooc.sso.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * http工具类
 *
 * @Author LQ
 * @CreateDate 2020/7/3 19:15
 * @Version 1.0
 */
public class HttpUtil {

    public static ResMessage doGet(String url, Map<String,String> param) {
        ResMessage resMessage = new ResMessage();
        HttpURLConnection httpURLConnection = null;
        URL targetUrl = null;
        try {
            // 拼装请求参数
            StringBuffer targetUrlStr = new StringBuffer(url).append("?");
            for(Map.Entry<String, String> entry : param.entrySet()){
                targetUrlStr.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = targetUrlStr.substring(0,targetUrlStr.length()-1);
            targetUrl = new URL(url);

            httpURLConnection = (HttpURLConnection) targetUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }

            br.close();
            isr.close();
            in.close();

            JSONObject resultJson = JSONObject.parseObject(sb.toString());
            resMessage.setRespCode(resultJson.getString("respCode"));
            resMessage.setRespMsg(resultJson.getString("respMsg"));

            JSONObject resultJsonMap = JSONObject.parseObject(resultJson.getString("respArgs"));
            resMessage.setRespArgs(resultJsonMap);
            return resMessage;
        } catch (Exception e) {
            resMessage.setRespCode("500");
            resMessage.setRespMsg("Cookie校验请求失败");
            return resMessage;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

    }
}
