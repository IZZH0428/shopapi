package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import org.apache.ibatis.annotations.Insert;

public interface ShopduckDao {
    @Insert("insert into t_shopduck " +
            "(name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,createDate,author,isDel,price) " +
            "value" +
            " (#{name},#{title},#{bandId},#{typeId},#{productdecs},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel},#{price})")
    void add(Shopduck shopduck);

    void update(Shopduck shopduck);
    @Insert("insert into t_shopAttr (proId,attrData,storcks,price)" +
            "value(#{proId},#{attrData},#{storcks},#{price})")
    void addvalue(ShopAttr shopAttr);
}
