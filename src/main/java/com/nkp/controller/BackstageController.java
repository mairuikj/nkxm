package com.nkp.controller;

import com.nkp.pojo.UserInfo;
import com.nkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BackstageController {
    @Autowired
    private UserService userService;
    @PostMapping("/backstage")
    public String backStage(String userName, String userPW, HttpServletRequest request){
        UserInfo userInfo=userService.check(userName,userPW);
        if(userInfo!=null){
            request.getSession().setAttribute("session_user",userInfo);
            return "index";
        }
        request.setAttribute("msg","账号或密码错误");
        return "login";

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/signout")
    public String signOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
