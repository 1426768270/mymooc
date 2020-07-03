package com.mymooc.sso.web.controller;

import com.mymooc.sso.web.util.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description  SSO登陆控制器
 * @Author       LQ
 * @CreateDate   2020/7/3 11:38
 * @Version      1.0
 */
@Controller
@RequestMapping("/sso")
public class LoginController {

    /**
     * 处理用户请求
     * @param username
     * @param password
     * @param gotoUrl
     * @param response
     * @return
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String username, String password,
                                String gotoUrl, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("login_fail");
        //校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username,password);
        //判断是否成功
        if (ok){
            Cookie cookie = new Cookie(LoginCheck.COOKIE_NAME,LoginCheck.COOKIE_VALUE);
            //顶级域名下所有可见
            cookie.setPath("/");
            response.addCookie(cookie);
            mv.setViewName("redirect:"+gotoUrl);
        }
        return mv;
    }

    /**
     * 跳转登陆页面
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
