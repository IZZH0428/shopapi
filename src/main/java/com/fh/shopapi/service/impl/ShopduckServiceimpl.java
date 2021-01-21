package com.fh.shopapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.shopapi.dao.ShopduckDao;
import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.service.ShopduckService;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShopduckServiceimpl implements ShopduckService {
    @Resource
    private ShopduckDao shopduckDao;





    /*
    *   List<DSShopValues> list1= new ArrayList<DSShopValues>();
    List<Object> list= JSONObject.parseArray(dsShop.getAttrData());
    for (int i = 0; i <list.size() ; i++) {
        DSShopValues dsShopValues=JSONObject.parseObject(String.valueOf(list.get(i)),DSShopValues.class);
        list1.add(dsShopValues);
    }
    dsShopValuesDao.addPlxz(list1);
    dsShop.setCreateDate(new Date());
    dsShop.setAuthor("预言家");
    dsShopDao.add(dsShop);
*/
    @Override
    @Transactional
    public Integer add(Shopduck shopduck,String sku) {
        List<ShopAttr> attrList = new ArrayList<>();
        List<Object> list = JSONObject.parseArray(sku);
        for (int i = 0; i <list.size() ; i++) {
            ShopAttr rs =  JSONObject.parseObject(String.valueOf(list.get(i)),ShopAttr.class);
            attrList.add(rs);
        }
        shopduckDao.addvalue(attrList);
        shopduck.setCreateDate(new Date());
        shopduck.setAuthor("test");
        shopduckDao.add(shopduck);
        return shopduck.getId();
    }

    @Override
    public void update(Shopduck shopduck) {
        shopduck.setUpdateDate(new Date());
        shopduckDao.update(shopduck);
    }


}
