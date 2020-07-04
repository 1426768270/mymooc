package com.mymooc.sso.demo1.x.com;

import com.mymooc.sso.util.HttpUtil;
import com.mymooc.sso.util.ResMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description   demo1的控制器
 * @Author       LQ
 * @CreateDate   2020/7/3 11:48
 * @Version      1.0
 */
@Controller
public class DemoOneController {

    @RequestMapping("/demo1")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            //校验cookie是否存在
            for(Cookie cookie : cookies){
                if("ssocookie".equals(cookie.getName())){
                    //向校验服务器发送校验请求
                    String url = "http://check.x.com:8080/sso/checkCookie";
                    ResMessage respMessage = HttpUtil.doGet(url, cookie.getName(), cookie.getValue());
                    if("200".equals(respMessage.getRespCode())){
                        mv.setViewName("demo1");
                        return mv;
                    }
                }
            }
        }
        mv.addObject("gotoUrl", "http://demo1.x.com:8080/demo1");
        mv.setViewName("login");
        return mv;
    }
}
