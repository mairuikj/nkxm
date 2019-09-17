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


    @RequestMapping("/user")
    public String accounts(){
        return "admin/accounts";
    }


    @RequestMapping("/signout")
    public String signOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }

    @RequestMapping("/news")
    public String products(){
        return "admin/products";
    }

    @RequestMapping("/add-product")
    public String addProduct(){
        return "admin/add-product";
    }
}
