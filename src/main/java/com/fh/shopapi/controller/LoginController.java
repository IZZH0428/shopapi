package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.User;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.LoginService;
import com.fh.shopapi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
    /*   登录
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
            if (newpassword.equals(user.getPassword())){
                map.put("msg",3);
            }else{
                map.put("msg",2);
            }
        }else{
            map.put("msg",1);
        }
        return map;
    }
    /*   注册
   路径  http://localhost:8080/api/login/addUser
   请求 post
  参数:name,realName,password,sex,phone,email,idCard,birthday,imgPath,eduId,deptId,
   返回值
         status": 200,
            "info": "处理成功",
            "data": null
       */
    @PostMapping("addUser")
    public ReponseData addUser(User user){
        user.setPassword(MD5Util.encoder(user.getPassword()));
        User user1 =loginService.queryUserByname(user.getName());
        if (user1==null){
            loginService.addUser(user);
        }else{
            return ReponseData.success(2);
        }
        return ReponseData.success(1);
    }
}
