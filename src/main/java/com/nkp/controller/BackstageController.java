package com.nkp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nkp.config.utils.DataPackJSON;
import com.nkp.dao.ShrioMapper;
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
import java.util.List;

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

/*    public DataPackJSON backStage(String userName, String userPW, HttpServletRequest request){
        UserInfo userInfo=userService.check(userName,userPW);
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        if(userInfo!=null){
            request.getSession().setAttribute("session_user",userInfo);
            map.put("session_user",(UserInfo)request.getSession().getAttribute("session_user"));
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            dataPackJSON.setMap(map);
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;

    }*/
    //访问外部API
    public  String visitThirdParties(MultiValueMap<String, String> params,String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();

    }
    //获取验证码
    @RequestMapping("/getcode")
    public DataPackJSON getCode(String phone){
        DataPackJSON dataPackJSON=new DataPackJSON();
        //等待调用获取验证码API
        return dataPackJSON;
    }
    //登录
    @RequestMapping("/backstage")
    public DataPackJSON backStage(String phone, String code, HttpServletRequest request){
        DataPackJSON dataPackJSON=new DataPackJSON();
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("phone",phone);
        params.add("verifyCode",code);
        params.add("token","DLO3303A10XMDO39X0TYZQAP3LXDJ3X19283E2RXWIK");
        String res=this.visitThirdParties(params,"https://console.yingpiao360.com/api/common/send-verify-code");
        if(res!=null){
            JSONObject data = (JSONObject) JSON.parse(res);
        }
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
