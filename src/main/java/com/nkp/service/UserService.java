package com.nkp.service;


import com.nkp.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserInfoMapper userDao;


    public List findAllUser(){
        return  userDao.findAllUser();
    }
}
