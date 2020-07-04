package com.mymooc.sso.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 登陆校验工具类
 * @Author LQ
 * @CreateDate 2020/7/3 11:27
 * @Version 1.0
 */
public class LoginCheck {

    /**
     * 测试用户名
     */
    public static final String USERNAME = "user";
    /**
     * 测试密码
     */
    public static final String PASSWORD = "123";
    /**
     * Cookie键
     */
    public static final String COOKIE_NAME = "ssocookie";
    /**
     * Cookie值
     */
    public static final String COOKIE_VALUE = "sso";

    /**
     * 登陆用户名和密码的校验
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean checkLogin(String username, String password) {
        if (USERNAME.equalsIgnoreCase(username) && PASSWORD.equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * 校验cookie
     *
     * @param request
     * @return
     */
    public static boolean checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (COOKIE_NAME.equals(cookie.getName()) && COOKIE_VALUE.equals(cookie.getValue())) {
                return true;
            }
        }
        return false;
    }

}
