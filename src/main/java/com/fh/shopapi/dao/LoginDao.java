package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {
    @Select("select * from t_user where name =#{name}")
    User queryUserByname(String name);
    @Insert("insert into t_user " +
            "(name,realName,password,sex,phone,email,idCard,birthday,imgPath,eduId,deptId,createDate)" +
            "value" +
            "(#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgPath},#{eduId},#{deptId},#{createDate})")
    void addUser(User user);
}
