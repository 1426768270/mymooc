package com.mymooc.sso.demo2;

import com.mymooc.sso.web.util.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description demo2的控制器
 * @Author LQ
 * @CreateDate 2020/7/3 11:51
 * @Version 1.0
 */
@Controller
public class DemoTwoController {

    @RequestMapping("/demo2")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (LoginCheck.checkCookie(request)) {
            mv.setViewName("demo2");
            return mv;
        }
        mv.addObject("gotoUrl", "/demo2");
        mv.setViewName("login");
        return mv;
    }
}
