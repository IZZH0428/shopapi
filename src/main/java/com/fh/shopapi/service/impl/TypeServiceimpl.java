package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.TypeDao;
import com.fh.shopapi.entity.po.Type;
import com.fh.shopapi.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceimpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    @Override
    public List<Type> getData() {
        return typeDao.getData();
    }

    @Override
    public List<Type> getDataByPid(Integer pid) {
        return typeDao.getDataByPid(pid);
    }

    @Override
    public Integer add(Type type) {
        type.setCreateDate(new Date());
        type.setIsDel(0);
        typeDao.add(type);

        return type.getId();
    }

    @Override
    public void update(Type type) {
        type.setUpdateDate(new Date());
        typeDao.update(type);
    }
}
