package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.ShopduckDao;
import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.service.ShopduckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ShopduckServiceimpl implements ShopduckService {
    @Resource
    private ShopduckDao shopduckDao;

    @Override
    public void add(Shopduck shopduck) {
        shopduck.setCreateDate(new Date());
        shopduck.setAuthor("test");
        shopduckDao.add(shopduck);
    }

    @Override
    public void update(Shopduck shopduck) {
        shopduck.setUpdateDate(new Date());
        shopduckDao.update(shopduck);
    }

    @Override
    public void addvalue(ShopAttr shopAttr) {
        shopduckDao.addvalue(shopAttr);
    }
}
