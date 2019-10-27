package com.nkp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nkp.config.utils.DataPackJSON;
import com.nkp.dao.ShrioMapper;
import com.nkp.dao.UserInfoMapper;
import com.nkp.pojo.Shrio;
import com.nkp.pojo.UserInfo;
import com.nkp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class BackstageController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ShrioMapper shrioMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/check")
    public DataPackJSON backStage(String phone, String code, HttpServletRequest request){
        HttpSession session=request.getSession();
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        UserInfo userInfo=userInfoMapper.selectByPhone(phone);
        if(userInfo!=null){
            String sessionCode=session.getAttribute("code").toString();
            if(sessionCode==null){
                dataPackJSON.setFlag(1);
                dataPackJSON.setMsg("验证码过期");
                return dataPackJSON;
            }
            if(sessionCode.equals(code)){
                session.setAttribute("session_user",userInfo);
                map.put("session_user",(UserInfo)request.getSession().getAttribute("session_user"));
                dataPackJSON.setFlag(0);
                dataPackJSON.setMsg("SUCCESS");
                dataPackJSON.setMap(map);
                return dataPackJSON;
            }else {
                dataPackJSON.setFlag(1);
                dataPackJSON.setMsg("验证码错误");
                return dataPackJSON;
            }
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;

    }
    //访问外部API公共方法
    public  String visitThirdParties(MultiValueMap<String, String> params,String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();

    }
    //获取验证码
    @RequestMapping("/getcode")
    public DataPackJSON getCode(String phone,HttpServletRequest request){
        HttpSession session=request.getSession();
        int code=(int)((Math.random()*9+1)*1000);
        session.setAttribute("code",code);
        DataPackJSON dataPackJSON=new DataPackJSON();
        UserInfo userInfo=userInfoMapper.selectByPhone(phone);
        if(userInfo!=null){
            //发送验证码
            MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
            params.add("phone",phone);
            params.add("verifyCode",String.valueOf(code));
            params.add("token","DLO3303A10XMDO39X0TYZQAP3LXDJ3X19283E2RXWIK");
            String res=this.visitThirdParties(params,"https://console.yingpiao360.com/api/common/send-verify-code");
            if(res!=null){
                JSONObject data = (JSONObject) JSON.parse(res);
                String res_data=data.getString("data");
                if("true".equals(res_data)){
                    dataPackJSON.setFlag(0);
                    dataPackJSON.setMsg("验证码已发送");
                    return dataPackJSON;
                }
            }
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("此用户不存在");
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
    public DataPackJSON addUser(HttpServletRequest request,UserInfo userInfo,@RequestBody JSONObject jsonParam){
        DataPackJSON dataPackJSON=new DataPackJSON();
        boolean res=userService.addUser(userInfo);
        if(res){
            upshrio(jsonParam,userInfo.getUserid());
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }

    @RequestMapping("/upUser")
    public DataPackJSON upUser(HttpServletRequest request,UserInfo userInfo,@RequestBody JSONObject jsonParam){
        DataPackJSON dataPackJSON=new DataPackJSON();
        boolean res=userService.upUser(userInfo);
        if(res){
            upshrio(jsonParam,userInfo.getUserid());
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
    @RequestMapping("/selById")
    public DataPackJSON selById(HttpServletRequest request,int id){
        return userService.selById(request,id);


    }

    @RequestMapping("/oneId")
    public DataPackJSON oneId(int id){
        return userService.oneId(id);


    }

    public  void upshrio(JSONObject jsonParam,int uid){
        //删除用户现有权限
        shrioMapper.deleteNewShrio(uid);
        List<List<Integer>> result=(List)jsonParam.get("shrio");
        for(int i=0;i<result.size();i++) {
            for (Integer cr : result.get(i)) {
                Shrio shrio = new Shrio();
                shrio.setUid(uid);
                shrio.setTid(i + 1);
                shrio.setCid(cr);
                shrioMapper.insertSelective(shrio);

            }
        }

    }









}
