package com.nkp.controller;

import com.nkp.config.utils.DataPackJSON;
import com.nkp.pojo.News;
import com.nkp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/add")
    public DataPackJSON add(HttpServletRequest request, News news) throws ParseException {
        return newsService.add(request,news);
    }
    @RequestMapping("/del")
    public DataPackJSON del(HttpServletRequest request, int id){
        return newsService.del(request,id);
    }
    @RequestMapping("/up")
    public DataPackJSON up(HttpServletRequest request, News news){
        return newsService.up(request,news);
    }

    @RequestMapping("/selById")
    public DataPackJSON selById(HttpServletRequest request,int id){
        return newsService.selById(request,id);
    }

    @RequestMapping("/selAll")
    public DataPackJSON selAll(HttpServletRequest request,Integer id){
        return newsService.selAll(request,id);
    }

    @RequestMapping("/pagingSel")
    public DataPackJSON pagingSel(HttpServletRequest request,int pageNum,int pageSize,Integer id){
        return newsService.pagingSel(request,pageNum,pageSize,id);
    }

    @RequestMapping("/getAT")
    public DataPackJSON getAT(HttpServletRequest request){
        return newsService.getTypeAndAuthor(request);
    }

}