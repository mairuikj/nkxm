package com.nkp.controller;

import com.nkp.config.utils.DataPackJSON;
import com.nkp.pojo.Author;
import com.nkp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/add")
    public DataPackJSON add(HttpServletRequest request, Author author){
        return authorService.add(request,author);
    }
    @RequestMapping("/del")
    public DataPackJSON del(HttpServletRequest request, int id){
        return authorService.del(request,id);
    }
    @RequestMapping("/up")
    public DataPackJSON up(HttpServletRequest request, Author author){
        return authorService.up(request,author);
    }

    @RequestMapping("/selById")
    public DataPackJSON selById(HttpServletRequest request,int id){
        return authorService.selById(request,id);
    }

    @RequestMapping("/selAll")
    public DataPackJSON selAll(HttpServletRequest request){
        return authorService.selAll(request);
    }
}
