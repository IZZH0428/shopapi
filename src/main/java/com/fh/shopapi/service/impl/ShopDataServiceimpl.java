package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.ShopDataDao;
import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.service.ShopDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopDataServiceimpl implements ShopDataService {
    @Resource
    private ShopDataDao shopDataDao;

    @Override
    public PageResult<ShopData> getData(PageParam2 param) {
        param.setName("%"+param.getName()+"%");
        Long count = shopDataDao.queryCount(param);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        param.setStartIndex((param.getPage()-1)*param.getLimit());//开始下标
        List<ShopData> data = shopDataDao.queryDateByPage(param);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<ShopData> rs=new PageResult<>(count,data);
        return rs;
    }
}
