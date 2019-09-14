package com.nkp.controller;

import com.nkp.config.utils.DataPackJSON;
import com.nkp.dao.NewsMapper;
import com.nkp.pojo.News;
import com.nkp.pojo.UserInfo;
import com.nkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class BackstageController {
    @Autowired
    private UserService userService;
    @RequestMapping("/backstage")
    public DataPackJSON backStage(String userName, String userPW, HttpServletRequest request){
        UserInfo userInfo=userService.check(userName,userPW);
        DataPackJSON dataPackJSON=new DataPackJSON();
        if(userInfo!=null){
            request.getSession().setAttribute("session_user",userInfo);
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;

    }

    @RequestMapping("/findAllUser")
    public DataPackJSON findAllUser(HttpServletRequest request){
        return userService.findAllUser(request);
    }

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }


    @RequestMapping("/add")
    public DataPackJSON addUser(HttpServletRequest request,UserInfo userInfo){
        DataPackJSON dataPackJSON=new DataPackJSON();
        boolean res=userService.addUser(userInfo);
        if(res){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }

    @RequestMapping("/upUser")
    public DataPackJSON upUser(HttpServletRequest request,UserInfo userInfo){
        DataPackJSON dataPackJSON=new DataPackJSON();
        boolean res=userService.upUser(userInfo);
        if(res){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }

    @RequestMapping("/del")
    public DataPackJSON del(HttpServletRequest request,int id){
        DataPackJSON dataPackJSON=new DataPackJSON();
        boolean res=userService.del(id);
        if(res){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }





}
