package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.DataValue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataValueDao {
    @Select("select * from t_datavalue where attId = #{attId} and isDel = 0")
    List<DataValue> getDataByAttId(Integer attId);
    @Insert("insert into t_datavalue (value,valueCH,attId) value (#{value},#{valueCH},#{attId})")
    void add(DataValue dataValue);
    @Select("select * from t_datavalue where id = #{id}")
    DataValue getDataById(Integer id);
    @Update("update t_datavalue set value=#{value},valueCH=#{valueCH} where id=#{id} ")
    void update(DataValue dataValue);
    @Delete("update  t_datavalue isDel = 1 where id =#{id}")
    void del(Integer id);
}
