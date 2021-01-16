package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface TypeDao {
    @Select("select * from t_type where isDel=0")
    List<Type> getData();
    @Select("select * from t_type where pid =#{pid}")
    List<Type> getDataByPid(Integer pid);
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_type (name,pid,createDate,isDel)value(#{name},#{pid},#{createDate},#{isDel})")
    void add(Type type);
    @Select("select id from t_type where createDate=#{createDate}")
    Integer selectByDate(Date createDate);
    @Update("<script>update t_type set updateDate=#{updateDate}" +
            " <if test='name != null and name != &quot;&quot;'>  , name  = #{name}</if>" +
            " <if test='pid != null and pid != &quot;&quot;'>  , pid  = #{pid}</if>" +
            " <if test='isDel != null and isDel != &quot;&quot;'>  , isDel  = #{isDel}</if>" +
            " where id=#{id} </script>")
    void update(Type type);
    @Select("select * from t_type where id =#{id}")
    List<Type> getDataById(Integer id);
}
