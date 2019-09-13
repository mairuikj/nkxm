package com.nkp.service;


import com.nkp.dao.UserInfoMapper;
import com.nkp.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserInfoMapper userDao;




    public UserInfo check(String userName, String userPW) {
        return  userDao.check(userName,userPW);
    }

    public List<UserInfo> findAllUser() {
        return userDao.findAllUser();
    }

    public boolean addUser(UserInfo userInfo) {
        int res=userDao.insertSelective(userInfo);
        if(res==1){
            return true;
        }
        return false;
    }

    public boolean upUser(UserInfo userInfo) {
        int res=userDao.updateByPrimaryKeySelective(userInfo);
        if(res==1){
            return true;
        }
        return false;
    }

    public boolean del(int id) {
        int res=userDao.deleteByPrimaryKey(id);
        if(res==1){
            return true;
        }
        return false;
    }
}
