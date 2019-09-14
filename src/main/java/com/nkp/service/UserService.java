package com.nkp.service;


import com.nkp.config.utils.DataPackJSON;
import com.nkp.dao.UserInfoMapper;
import com.nkp.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserInfoMapper userDao;




    public UserInfo check(String userName, String userPW) {
        return  userDao.check(userName,userPW);
    }

    public DataPackJSON findAllUser(HttpServletRequest request) {
        Map map=new HashMap();
        HttpSession session = request.getSession();
        List list=userDao.findAllUser();
        DataPackJSON dataPackJSON=new DataPackJSON();

        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        map.put("lists",list);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        dataPackJSON.setNumber(list.size());
        return dataPackJSON;

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
