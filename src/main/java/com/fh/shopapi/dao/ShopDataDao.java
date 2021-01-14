package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopDataDao {
    @Select("<script>  select count(1) from t_data where isdel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam2 param);
    @Select("<script>  select * from t_data where isdel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            "  limit #{startIndex},#{limit} </script>")
    List<ShopData> queryDateByPage(PageParam2 param);
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_data (name,nameCH,typeId,type,isSKU,isDel,createDate,author) value " +
            "                  (#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    void add(ShopData shopData);
    @Update("update t_data set name = #{name}, nameCH=#{nameCH},typeId=#{typeId}" +
            ",type=#{type},isSKU=#{isSKU},updateDate = #{updateDate},author=#{author} where id =#{id}")
    void update(ShopData shopData);
    @Update("update t_data set isDel =#{isDel},updateDate=#{updateDate} where id=#{id}")
    void del(ShopData shopData);
}
