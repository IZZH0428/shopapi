package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;

public interface ShopduckService {
    Integer add(Shopduck shopduck,String sku);

    void update(Shopduck shopduck);

}
