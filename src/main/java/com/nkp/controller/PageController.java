package com.nkp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/signout")
    public String signOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
