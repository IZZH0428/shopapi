package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;

public interface ShopduckService {
    void add(Shopduck shopduck);

    void update(Shopduck shopduck);

    void addvalue(ShopAttr shopAttr);
}
