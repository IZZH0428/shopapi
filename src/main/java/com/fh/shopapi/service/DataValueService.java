package com.fh.shopapi.service;


import com.fh.shopapi.entity.po.DataValue;

import java.util.List;

public interface DataValueService {

    List<DataValue> getDataByAttId(Integer attId);

    void add(DataValue dataValue);

    DataValue getDataById(Integer id);

    void update(DataValue dataValue);

    void del(Integer id);
}
