package com.nkp.service;


import com.nkp.config.utils.DataPackJSON;
import com.nkp.config.utils.NewDateTime;
import com.nkp.dao.ShrioMapper;
import com.nkp.dao.UserInfoMapper;
import com.nkp.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserInfoMapper userDao;

    @Autowired
    private ShrioMapper shrioMapper;




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
        try {
            userInfo.setCreatetime(NewDateTime.getDateTime("yyyy-MM-dd :HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public DataPackJSON selById(HttpServletRequest request,int id) {
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        UserInfo userInfo=userDao.selectByPrimaryKey(id);

        //map.put("session_user",request.getSession().getAttribute("session_user"));
        map.put("session_user",userInfo);
        List<List> shrio=new ArrayList<>();
        for(int i=1;i<=5;i++){
            List temp=shrioMapper.selShrio(id,i);
            shrio.add(temp);
        }
        map.put("shrio",shrio);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");

        dataPackJSON.setMap(map);
        return dataPackJSON;
    }

    public DataPackJSON oneId(int id){
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        UserInfo userInfo=userDao.selectByPrimaryKey(id);
        map.put("user",userInfo);
        dataPackJSON.setMap(map);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        return dataPackJSON;
    }
}
