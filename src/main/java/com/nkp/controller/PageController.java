package com.nkp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/login")//登录页
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/index")//首页
    public String index(){
        return "admin/index";
    }


    @RequestMapping("/userList")//用户信息列表
    public String accounts(){
        return "admin/accounts";
    }


    @RequestMapping("/signout")//退出
    public String signOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "admin/login";
    }

    @RequestMapping("/activityList")//活动列表
    public String activityList(){
        return "admin/activityList";
    }

    @RequestMapping("/addActivity")//活动添加
    public String addActivity(){
        return "admin/add-activity";
    }

    @RequestMapping("/editActivity")//活动编辑
    public String editActivity(){
        return "admin/edit-activity";
    }



    @RequestMapping("/newsList")//文章列表
    public String products(){
        return "admin/products";
    }

    @RequestMapping("/addNews")//添加文章
    public String addNews(){
        return "admin/add-product";
    }

    @RequestMapping("/editNews")//编辑文章
    public String editProduct(){
        return "admin/edit-product";
    }



    @RequestMapping("/authorList")//作者列表
    public String authorList(){
        return "admin/authorList";
    }

    @RequestMapping("/editAuthor")//编辑作者
    public String editAuthor(){
        return "admin/edit-author";
    }

    @RequestMapping("/addAuthor")//添加作者
    public String addAuthor(){
        return "admin/add-author";
    }



    @RequestMapping("/addProduct")//添加产品
    public String productAdd(){
        return "admin/productAdd";
    }

    @RequestMapping("/editProduct")//编辑产品
    public String productEdit(){
        return "admin/productEdit";
    }


    @RequestMapping("/productList")//产品列表
    public String productsList(){
        return "admin/productsList";
    }








}
