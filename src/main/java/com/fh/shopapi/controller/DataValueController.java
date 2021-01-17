package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.DataValue;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.DataValueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/value/")
public class DataValueController {
    @Resource
    private DataValueService dataValues;
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
         List<DataValue> rs =dataValues.getDataByAttId(attId);
         return ReponseData.success(rs);
     }
      /*   1    新增
    路径   http://localhost:8080/api/value/add
    post请求
   参数:value valueCH attId
    返回值
        status": 200,
        "info": "处理成功",
        "data":
        */
      @PostMapping("add")
      public ReponseData add(DataValue dataValue){
          dataValues.add(dataValue);
          return ReponseData.success(null);
      }
      /*   1    回显
    路径   http://localhost:8080/api/value/getDataById
    get请求
   参数:id
    返回值
        status": 200,
        "info": "处理成功",
        "data":{}
        */
      @GetMapping("getDataById")
    public ReponseData getDataById(Integer id){
          DataValue rs =dataValues.getDataById(id);
          return  ReponseData.success(rs);
      }
      /*   1    修改
    路径   http://localhost:8080/api/value/update
    get请求
   参数:value valueCH id
    返回值
        status": 200,
        "info": "处理成功",
        "data":
        */
      @PostMapping("update")
      public ReponseData update(DataValue dataValue){
          dataValues.update(dataValue);
          return ReponseData.success(null);
      }
}
