package com.fh.shopapi.controller;

import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.service.ShopDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
