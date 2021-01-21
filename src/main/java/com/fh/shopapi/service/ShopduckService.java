package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.entity.vo.PageParam3;
import com.fh.shopapi.entity.vo.PageResult;

public interface ShopduckService {
    Integer add(Shopduck shopduck,String sku);

    void update(Shopduck shopduck);

    PageResult<Shopduck> getData(PageParam3 param);

    Shopduck queryDuckById(Integer id);

    void del(Integer id);
}
