package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.DataValue;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.DataValueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("api/value/")
public class DataValueController {
    @Resource
    private DataValueService dataValue;
     /*   1    查询
    路径   http://localhost:8080/api/value/getDataByAttId
    get请求
   参数:attId
    返回值
        status": 200,
        "info": "处理成功",
        "data": [*]
        */
     @GetMapping("getDataByAttId")
     public ReponseData getDataByAttId(Integer attId){
         DataValue rs =dataValue.getDataByAttId(attId);
         return ReponseData.success(rs);
     }
}
