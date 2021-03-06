package com.mooc.email.controller;

import com.mooc.email.domain.User;
import com.mooc.email.service.UserService;
import com.mooc.email.util.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("/regist")
    public ModelAndView toRegistPage(){
        return new ModelAndView("regist");
    }
    /**
     * 处理用户注册请求
     * @return
     */
    @PostMapping("/regist")
    public ModelAndView regist(User user){
        user.setState(0);// 0，未激活；1，已激活
        String code = UuidUtils.getUuid()+UuidUtils.getUuid();
        user.setCode(code);
        // 调用业务层处理数据
        userService.regist(user);
        // 页面跳转

        return new ModelAndView("regist");
    }

    /**
     * 处理用户激活请求
     * @return
     */
    @GetMapping("/regist/active")
    @ResponseBody
    public Object registActive(@RequestParam("code") String code){

        boolean result = userService.registActive(code);

        return "激活状态："+result;
    }

}
