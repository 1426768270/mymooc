package com.mooc.email.util;

import java.util.UUID;

/**
 * 生成随机字符串工具类
 * @Author       LQ
 * @CreateDate   2020/7/4 14:50
 * @Version      1.0
 */
public class UuidUtils {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
