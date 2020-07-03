package com.mymooc.sso.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Description  登陆校验工具类
 * @Author       LQ
 * @CreateDate   2020/7/3 11:27
 * @Version      1.0
 */
public class LoginCheck {

    /** 测试用户名 */
    public static final String USERNAME="user";
    /** 测试密码*/
    public static final String PASSWORD="123";
    /** Cookie键 */
    public static final String COOKIE_NAME = "ssocookie";
    /** Cookie值*/
    public static final String COOKIE_VALUE = "sso";

    /**
     *登陆用户名和密码的校验
     * @param username
     * @param password
     * @return
     */
    public static boolean checkLogin(String username,String password){
        if (USERNAME.equalsIgnoreCase(username) && PASSWORD.equals(password)){
            return true;
        }
        return false;
    }

    /**
     * 校验cookie
     * @param cookieName
     * @param cookieValue
     * @return
     */
    public static boolean checkCookie(String cookieName ,String cookieValue){
        if (cookieName == null || cookieName=="") {
            return false;
        }
        if (cookieValue == null || cookieValue=="") {
            System.out.println(cookieValue);
            return false;
        }
        if (COOKIE_NAME.equals(cookieName) && COOKIE_VALUE.equals(cookieValue)) {
            return true;
        }
        return false;
    }

}
