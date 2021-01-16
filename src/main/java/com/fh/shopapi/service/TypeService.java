package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.Type;

import java.util.List;

public interface TypeService {

    List<Type> getData();

    List<Type> getDataByPid(Integer pid);

    Integer add(Type type);

    void update(Type type);

    List<Type> getDataByid(Integer id);
}
