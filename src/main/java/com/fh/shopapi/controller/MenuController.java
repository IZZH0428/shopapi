package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.Menu;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu/")
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;
     /*      查询权限
    路径   http://localhost:8080/api/menu/getData
    请求   get
    参数
    返回值   {"code":200,"message":"提示",data:[{*}]}*/
    @GetMapping("getData")
    public ReponseData getData(){
        List<Menu> rs = menuService.getData();
        return ReponseData.success(rs);
    }
    /*       新增权限
    路径   http://localhost:8080/api/menu/add
    请求  post
    参数  name,pid,url,type,
    返回值   {"code":200,"message":"提示",data:null*/
    @PostMapping("add")
    public ReponseData add(Menu menu){
        menuService.add(menu);
        return ReponseData.success(null);
    }
     /*       修改权限
    路径   http://localhost:8080/api/menu/update
    请求  post
    参数  name,url,type,id
    返回值   {"code":200,"message":"提示",data:null*/
     @PostMapping("update")
     public ReponseData update(Menu menu){
         menuService.update(menu);
         return ReponseData.success(null);
     }
       /*       删除权限
    路径   http://localhost:8080/api/menu/del
    请求  post
    参数  id
    返回值   {"code":200,"message":"提示",data:null*/
       @PostMapping("del")
       public ReponseData del(Integer id){
           menuService.del(id);
           return ReponseData.success(null);
       }
}
