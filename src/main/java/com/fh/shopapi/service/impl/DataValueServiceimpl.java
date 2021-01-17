package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.DataValueDao;
import com.fh.shopapi.entity.po.DataValue;
import com.fh.shopapi.service.DataValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataValueServiceimpl implements DataValueService {
    @Resource
    private DataValueDao valueDao;

    @Override
    public List<DataValue> getDataByAttId(Integer attId) {
        return valueDao.getDataByAttId(attId);
    }

    @Override
    public void add(DataValue dataValue) {
        valueDao.add(dataValue);
    }

    @Override
    public DataValue getDataById(Integer id) {
        return valueDao.getDataById(id);
    }

    @Override
    public void update(DataValue dataValue) {
        valueDao.update(dataValue);
    }
}
