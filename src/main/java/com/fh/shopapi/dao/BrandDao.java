package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.vo.PageParam1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandDao {
    @Select("<script>  select count(1) from t_brand where isdel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam1 param);
    @Select("<script>  select * from t_brand where isdel =0" +
            " <if test='name != null and name != &quot;%null%&quot;'>  and name  like #{name}</if>" +
            " order by ord desc limit #{startIndex},#{limit} </script>")
    List<Brand> queryDateByPage(PageParam1 param);
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_brand (name,bandE,imgpath,bandDesc,ord,isdel,createDate,author) value " +
            "                  (#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},#{isdel},#{createDate},#{author})")
    void add(Brand brand);
    @Select("select id,name,bandE,imgpath,bandDesc,ord from t_brand where id=#{id}")
    Brand queryByid(Integer id);
    @Update("update t_brand set name=#{name},bandE=#{bandE},bandDesc=#{bandDesc},ord=#{ord},updateDate=#{updateDate},imgpath=#{imgpath},author=#{author} where id =#{id}")
    void update(Brand brand);
    @Update("update t_brand set isdel =#{isdel},updateDate=#{updateDate} where id=#{id}")
    void del(Brand brand);
}
