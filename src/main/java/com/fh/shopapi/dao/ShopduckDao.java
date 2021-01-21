package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

public interface ShopduckDao {

    @Insert("insert into t_shopduck " +
            "(name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,createDate,author,isDel,price) " +
            "value" +
            " (#{name},#{title},#{bandId},#{typeId},#{productdecs},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel},#{price})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void add(Shopduck shopduck);

    void update(Shopduck shopduck);

    @Insert("<script>" +
            "insert into  t_shopattr(proId,attrData,storcks,price)" +
            "values" +
            "<foreach item='list1' collection='list' separator=','>" +
            "(#{list1.proId},#{list1.attrData},#{list1.storcks},#{list1.price})"+
            "</foreach>" +
            "</script>")
    void addvalue(List<ShopAttr> attrList);
}
