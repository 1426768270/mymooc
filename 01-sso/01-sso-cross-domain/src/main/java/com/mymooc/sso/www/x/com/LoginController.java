package com.mymooc.sso.www.x.com;


import com.mymooc.sso.util.ResMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description SSO登陆控制器
 * @Author LQ
 * @CreateDate 2020/7/3 11:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/sso")
public class LoginController {

    /**
     * 校验用户信息
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/doLogin")
    @ResponseBody
    public ResMessage doLogin(String username,String password) {
        ResMessage result = new ResMessage();
        result.setRespCode("500");
        result.setRespMsg("用户名或密码错误");

        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username,password);
        // 判断是否登录成功
        if (ok) {
            result.setRespCode("200");
            result.setRespMsg("用户名和密码正确");

            List<Map<String,String>> targetCookies = new ArrayList<Map<String,String>>();

            // 向www.a.com服务器发送增加cookie
            Map<String,String> targetCookiea = new HashMap<String,String>();
            String urla = "http://www.a.com:8080/a/addCookie";
            targetCookiea.put("targetUrl", urla);
            targetCookiea.put("cookieName", LoginCheck.COOKIE_NAME);
            targetCookiea.put("cookieValue", LoginCheck.COOKIE_VALUE);

            // 向www.b.com服务器发送增加cookie
            Map<String,String> targetCookieb = new HashMap<String,String>();
            String urlb = "http://www.b.com:8080/b/addCookie";
            targetCookieb.put("targetUrl", urlb);
            targetCookieb.put("cookieName", LoginCheck.COOKIE_NAME);
            targetCookieb.put("cookieValue", LoginCheck.COOKIE_VALUE);

            targetCookies.add(targetCookiea);
            targetCookies.add(targetCookieb);

            Map<String,Object> args = new HashMap<String,Object>();
            args.put("targetCookies", targetCookies);

            result.setRespArgs(args);

        }
        return result;
    }

    /**
     * 校验cookie
     * @param cookieName
     * @param cookieValue
     * @return
     */
    @GetMapping("/checkCookie")
    @ResponseBody
    public ResMessage checkCookie(String cookieName,String cookieValue){
        ResMessage result = new ResMessage();
        result.setRespCode("500");
        result.setRespMsg("CookieName或CookieValue无效");
        boolean isOk = LoginCheck.checkCookie(cookieName, cookieValue);
        if(isOk){
            result.setRespCode("200");
            result.setRespMsg("Cookie有效");
        }
        return result;
    }
}
