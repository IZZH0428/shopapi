package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.ShopduckService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/duck")
@CrossOrigin
public class ShopduckController {
    @Resource
    private ShopduckService service;

    /*      新增
    路径   http://localhost:8080/api/duck/add
    post请求
   参数:name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,price
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null
        */
    @PostMapping("add")
    public ReponseData add(Shopduck shopduck){
        service.add(shopduck);
        return ReponseData.success(null);
    }
}
