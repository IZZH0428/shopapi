package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import com.fh.shopapi.entity.vo.PageResult;

import java.util.List;

public interface ShopDataService {
    PageResult<ShopData> getData(PageParam2 param);

    Integer add(ShopData shopData);

    void update(ShopData shopData);

    void del(ShopData shopData);

    ShopData queryByid(Integer id);

    List<ShopData> getAllData();

    List<ShopData> getDataByTypeId(Integer typeId);
}
