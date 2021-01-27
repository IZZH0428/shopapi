package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.User;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.LoginService;
import com.fh.shopapi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login/")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;
    /*   1
   路径   http://localhost:8080/api/login/userLogin
   请求 post
  参数:name , password
   返回值
        map
       */
    @RequestMapping("userLogin")
    public Map userLogin(String name,String password){
        Map map = new HashMap();
        User user =loginService.queryUserByname(name);
        if (user != null){
           String newpassword = MD5Util.encoder(password);
            if (newpassword==user.getPassword()){
                map.put("msg",3);
            }else{
                map.put("msg",2);
            }
        }else{
            map.put("msg",1);
        }
        return map;
    }
}
