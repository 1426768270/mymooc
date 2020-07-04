package com.mymooc.sso.demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.mymooc.sso.util.HttpUtil;
import com.mymooc.sso.util.ResMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * demo2的控制器
 *
 * @Author LQ
 * @CreateDate 2020/7/3 19:56
 * @Version 1.0
 */
@Controller
public class DemoTwoController {

    @RequestMapping("/demo2")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            //校验cookie是否存在
            for (Cookie cookie : cookies) {
                if ("ssocookie".equals(cookie.getName())) {
                    //向校验服务器发送校验请求
                    String url = "http://check.x.com/sso/checkCookie";
                    ResMessage respMessage = HttpUtil.doGet(url, cookie.getName(), cookie.getValue());
                    if ("200".equals(respMessage.getRespCode())) {
                        mv.setViewName("demo2");
                        return mv;
                    }
                }
            }
        }
        mv.addObject("gotoUrl", "http://demo2.x.com/demo2");
        mv.setViewName("login");
        return mv;
    }
}
