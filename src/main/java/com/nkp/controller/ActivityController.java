package com.nkp.controller;

import com.nkp.config.utils.DataPackJSON;
import com.nkp.pojo.Activity;
import com.nkp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/add")
    public DataPackJSON add(HttpServletRequest request, Activity activity){
        return activityService.add(request,activity);
    }
    @RequestMapping("/del")
    public DataPackJSON del(HttpServletRequest request, int id){
        return activityService.del(request,id);
    }
    @RequestMapping("/up")
    public DataPackJSON up(HttpServletRequest request, Activity activity){
        return activityService.up(request,activity);
    }

    @RequestMapping("/selById")
    public DataPackJSON selById(HttpServletRequest request,int id){
        return activityService.selById(request,id);
    }

    @RequestMapping("/selAll")
    public DataPackJSON selAll(HttpServletRequest request){
        return activityService.selAll(request);
    }
}