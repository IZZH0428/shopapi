package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.vo.PageParam;
import com.fh.shopapi.entity.vo.PageParam1;
import com.fh.shopapi.entity.vo.PageResult;

import java.util.List;

public interface BrandService {
    PageResult<Brand> getData(PageParam1 param);

    Integer add(Brand brand);

    Brand queryByid(Integer id);

    void update(Brand brand);

    void del(Brand brand);
}
