package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.User;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {
    @Select("select * from t_user where name =#{name}")
    User queryUserByname(String name);
}
