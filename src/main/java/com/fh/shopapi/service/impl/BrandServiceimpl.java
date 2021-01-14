package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.BrandDao;
import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.vo.PageParam1;
import com.fh.shopapi.entity.vo.PageResult;
import com.fh.shopapi.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BrandServiceimpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    @Override
    public PageResult<Brand> getData(PageParam1 param) {
        param.setName("%"+param.getName()+"%");
        Long count = brandDao.queryCount(param);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        param.setStartIndex((param.getPage()-1)*param.getLimit());//开始下标
        List<Brand> data = brandDao.queryDateByPage(param);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<Brand> rs=new PageResult<>(count,data);
        return rs;
    }

    @Override
    public Integer add(Brand brand) {
        brand.setCreateDate(new Date());
        brand.setIsdel(0);
        brandDao.add(brand);
        return brand.getId();
    }

    @Override
    public Brand queryByid(Integer id) {
        return brandDao.queryByid(id);
    }

    @Override
    public void update(Brand brand) {
        brand.setUpdateDate(new Date());
        brandDao.update(brand);
    }

    @Override
    public void del(Brand brand) {
        brand.setUpdateDate(new Date());
        brand.setIsdel(1);
        brandDao.del(brand);
    }


}
