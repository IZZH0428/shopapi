package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.entity.vo.ReponseData;
import com.fh.shopapi.service.ShopDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/shopData/")
@CrossOrigin
public class ShopDataController {
    @Resource
    private ShopDataService shopDataService;
    /*   1    查询所有的分类数据
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
   参数:name,nameCH,typeId,type,isSKU,isDel,author
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
}
