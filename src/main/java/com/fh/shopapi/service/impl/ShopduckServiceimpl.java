package com.fh.shopapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.shopapi.dao.ShopduckDao;
import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.entity.vo.PageParam3;
import com.fh.shopapi.entity.vo.PageResult;
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






    @Override
    @Transactional
    public Integer add(Shopduck shopduck,String sku) {
        List<ShopAttr> attrList = new ArrayList<>();
        shopduck.setCreateDate(new Date());
        shopduck.setAuthor("test");
        shopduckDao.add(shopduck);
        List<Object> list = JSONObject.parseArray(sku);
        for (int i = 0; i <list.size() ; i++) {
            ShopAttr rs =  JSONObject.parseObject(String.valueOf(list.get(i)),ShopAttr.class);
            rs.setProId(shopduck.getId());
            attrList.add(rs);
        }
        shopduckDao.addvalue(attrList);

        return shopduck.getId();
    }

    @Override
    public void update(Shopduck shopduck) {
        shopduck.setUpdateDate(new Date());
        shopduckDao.update(shopduck);
    }

    @Override
    public PageResult<Shopduck> getData(PageParam3 param) {
        param.setName("%"+param.getName()+"%");
        Long count = shopduckDao.queryCount(param);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        param.setStartIndex((param.getPage()-1)*param.getLimit());//开始下标
        List<Shopduck> data = shopduckDao.queryDateByPage(param);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<Shopduck> rs=new PageResult<>(count,data);
        return rs;
    }

    @Override
    public Shopduck queryDuckById(Integer id) {
        return shopduckDao.queryDuckById(id);
    }

    @Override
    public void del(Integer id) {
        shopduckDao.del(id);
    }

    @Override
    public void updateData(Shopduck shopduck,String sku) {
        List<ShopAttr> attrList = new ArrayList<>();
        List<Object> list = JSONObject.parseArray(sku);
        for (int i = 0; i <list.size() ; i++) {
            ShopAttr rs =  JSONObject.parseObject(String.valueOf(list.get(i)),ShopAttr.class);
            rs.setProId(shopduck.getId());
            attrList.add(rs);
        }
        shopduckDao.deleteDataByProId(shopduck.getId());
        shopduckDao.addvalue(attrList);
    }

    @Override
    public List<ShopAttr> queryshopatt(Integer id) {
        return shopduckDao.queryshopatt(id);
    }


}
