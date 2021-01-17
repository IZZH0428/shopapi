package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.DataValueDao;
import com.fh.shopapi.entity.po.DataValue;
import com.fh.shopapi.service.DataValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DataValueServiceimpl implements DataValueService {
    @Resource
    private DataValueDao valueDao;

    @Override
    public DataValue getDataByAttId(Integer attId) {
        return valueDao.getDataByAttId(attId);
    }
}
