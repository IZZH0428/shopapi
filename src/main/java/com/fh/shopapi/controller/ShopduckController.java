package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.entity.vo.PageParam3;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.ShopduckService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/duck")
@CrossOrigin
public class ShopduckController {
    @Resource
    private ShopduckService service;

    /*      新增
    路径   http://localhost:8080/api/duck/add
    post请求
   参数:name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,price sku
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null
        */
    @PostMapping("add")
    public ReponseData add(Shopduck shopduck,String sku){
        Integer id = service.add(shopduck,sku);
        return ReponseData.success(id);
    }
       /*      修改
    路径   http://localhost:8080/api/duck/update
    post请求
   参数:name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,price id
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null
        */
       @PostMapping("update")
       public ReponseData update(Shopduck shopduck){
           service.update(shopduck);
           return ReponseData.success(null);
       }
    /*   1    查询所有的品牌数据（分页）
    路径   http://localhost:8080/api/duck/getData
    get请求
   参数:limit(每页条数) page（当前页）
    返回值
         "code": 0,
        "msg": "处理成功",
        "count": ,
        "data": []
        */
    @GetMapping("getData")
    public PageResult<Shopduck> getData(PageParam3 param){
        PageResult<Shopduck> rs = service.getData(param);
        return rs;
    }
/*   1    查询所有的品牌数据（分页）
    路径   http://localhost:8080/api/duck/queryDuckById
    get请求
   参数:limit(每页条数) page（当前页）
    返回值
         "code": 0,
        "msg": "处理成功",
        "count": ,
        "data": []
        */
    @RequestMapping("queryDuckById")
    public ReponseData queryDuckById(Integer id){
        Shopduck rs = service.queryDuckById(id);
        return ReponseData.success(rs);
    }
    /*   1    查询所有的品牌数据（分页）
        路径   http://localhost:8080/api/duck/del
        post请求
       参数:id
        返回值
             "code": 0,
            "msg": "处理成功",
            "count": ,
            "data": []
            */
    @PostMapping("del")
    public ReponseData del(Integer id){
            service.del(id);
        return ReponseData.success(null);
    }
     /*      修改属性
    路径   http://localhost:8080/api/duck/updateData
    post请求
   参数:name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,price sku
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null
        */
     @PostMapping("updateData")
     public ReponseData updateData(Shopduck shopduck,String sku){
         service.updateData(shopduck,sku);
         return ReponseData.success(null);
     }

     /*      修改属性
    路径   http://localhost:8080/api/duck/queryshopatt
    post请求
   参数: id
    返回值"
    status": 200,
    "info": "处理成功",
    "data": null
        */
     @RequestMapping("queryshopatt")
     public ReponseData queryshopatt(Integer id){
         List<ShopAttr> rs = service.queryshopatt(id);
         return ReponseData.success(rs);
     }

}
