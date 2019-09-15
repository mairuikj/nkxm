package com.nkp.controller;

import com.nkp.config.utils.DataPackJSON;
import com.nkp.pojo.Product;
import com.nkp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public DataPackJSON add(HttpServletRequest request, Product product){
        return productService.add(request,product);
    }
    @RequestMapping("/del")
    public DataPackJSON del(HttpServletRequest request, int id){
        return productService.del(request,id);
    }
    @RequestMapping("/up")
    public DataPackJSON up(HttpServletRequest request, Product product){
        return productService.up(request,product);
    }

    @RequestMapping("/selById")
    public DataPackJSON selById(HttpServletRequest request,int id){
        return productService.selById(request,id);
    }

    @RequestMapping("/selAll")
    public DataPackJSON selAll(HttpServletRequest request){
        return productService.selAll(request);
    }

}
