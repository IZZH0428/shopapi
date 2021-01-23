package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.ShopAttr;
import com.fh.shopapi.entity.po.Shopduck;
import com.fh.shopapi.entity.vo.PageParam3;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopduckDao {

    @Insert("insert into t_shopduck " +
            "(name,title,bandId,typeId,productdecs,imgPath,stocks,sortNum,createDate,author,isDel,price) " +
            "value" +
            " (#{name},#{title},#{bandId},#{typeId},#{productdecs},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel},#{price})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void add(Shopduck shopduck);
    @Update("update  t_shopduck set name=#{name},title=#{title}," +
            "bandId=#{bandId},productdecs=#{productdecs},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum}" +
            ",updateDate=#{updateDate},price=#{price} where id=#{id}")
    void update(Shopduck shopduck);

    @Insert("<script>" +
            "insert into  t_shopattr(proId,attrData,storcks,price)" +
            "values" +
            "<foreach item='list1' collection='list' separator=','>" +
            "(#{list1.proId},#{list1.attrData},#{list1.storcks},#{list1.price})"+
            "</foreach>" +
            "</script>")
    void addvalue(List<ShopAttr> attrList);
    @Select("<script>  select count(1) from t_shopduck where isDel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam3 param);
    @Select("<script>  select * from t_shopduck where isDel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            " order by id desc limit #{startIndex},#{limit} </script>")
    List<Shopduck> queryDateByPage(PageParam3 param);
    @Select(" select * from t_shopduck where id =#{id}")
    Shopduck queryDuckById(Integer id);
    @Update("update  t_shopduck set isDel=1 where id=#{id}")
    void del(Integer id);
    @Delete("delete from t_shopattr where proId =#{id}")
    void deleteDataByProId(Integer id);
    @Select("select * from t_shopattr where proId =#{id}")
    List<ShopAttr> queryshopatt(Integer id);
}
