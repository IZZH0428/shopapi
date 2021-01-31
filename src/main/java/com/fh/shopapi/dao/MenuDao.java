package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MenuDao {
    @Select("select * from t_menu where isDel=0")
    List<Menu> getData();
    @Insert("insert into t_menu" +
            "(name,pid,url,type,isDel,createDate,author)" +
            "value" +
            "(#{name},#{pid},#{url},#{type},#{isDel},#{createDate},#{author})")
    void add(Menu menu);
    @Update("update t_menu set name=#{name},url=#{url},type=#{type} where id=#{id}")
    void update(Menu menu);
    @Update("update t_menu set isDel =1 where id=#{id}")
    void del(Integer id);
}
