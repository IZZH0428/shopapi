package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.ShopDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/shopData/")
@CrossOrigin
public class ShopDataController {
    @Resource
    private ShopDataService shopDataService;
    /*   1    查询所有的属性数据
    路径   http://localhost:8080/api/shopData/getData
    get请求
   参数:limit(每页条数) page（当前页）
    返回值
         "code": 0,
        "msg": "处理成功",
        "count": ,
        "data": [*]
        */
    @GetMapping("getData")
    public  PageResult<ShopData> getData(PageParam2 param){
        PageResult<ShopData> rs = shopDataService.getData(param);
        return rs;
    }
      /*      新增
    路径   http://localhost:8080/api/shopData/add
    post请求
   参数:name,nameCH,typeId,type,isSKU,author
    返回值"
    status": 200,
    "info": "处理成功",
    "data": id

        */
    @PostMapping("add")
    public ReponseData add(ShopData shopData){
        Integer  id=    shopDataService.add(shopData);
        return ReponseData.success(id);
    }

    /*       修改
          路径   http://localhost:8080/api/shopData/update
          post请求
         参数:name,nameCH,typeId,type,isSKU,author
          返回值"
          status": 200,
          "info": "处理成功",
          "data": null
      */
    @PostMapping("update")
    public ReponseData update(ShopData shopData){
        shopDataService.update(shopData);
        return ReponseData.success(null);
    }
    /*       删除
       路径   http://localhost:8080/api/shopData/del
       post请求
       参数:id
       返回值"
       status": 200,
       "info": "处理成功",
       "data": null
   */
    @PostMapping("del")
    public  ReponseData del(ShopData shopData){
        shopDataService.del(shopData);
        return ReponseData.success(null);
    }
    /*       回显
 路径   http://localhost:8080/api/shopData/queryByid
 post请求
参数:id
 返回值"
 status": 200,
 "info": "处理成功",
 "data":  "id": ,
     "name": "",
     "bandE": "",
     "imgpath": "",
     "bandDesc": "",
     "ord": ,
     "isdel": ,
     "createDate": "",
     "updateDate": ,
     "author": ""
     */
    @PostMapping("queryByid")
    public ReponseData queryByid(Integer id){
        ShopData shopData  =shopDataService.queryByid(id);
        return ReponseData.success(shopData);
    }
    /*   1    查询所有的属性数据（分页）
   路径   http://localhost:8080/api/shopData/getAllData
   get请求
  参数:limit(每页条数) page（当前页）
   返回值
        "code": 0,
       "msg": "处理成功",
       "count": ,
       "data": [*]
       */
    @GetMapping("getAllData")
    public  ReponseData getAllData(){
        List<ShopData> rs = shopDataService.getAllData();
        return ReponseData.success(rs);
    }
    /*   1    查询所有的属性数据（分页）
   路径   http://localhost:8080/api/shopData/getDataByTypeId
   get请求
  参数:limit(每页条数) page（当前页）
   返回值
        "code": 0,
       "msg": "处理成功",
       "count": ,
       "data": [*]
       */
    @GetMapping("getDataByTypeId")
    public  ReponseData getDataByTypeId(Integer typeId){
        List<ShopData> rs = shopDataService.getDataByTypeId(typeId);
        return ReponseData.success(rs);
    }
}
