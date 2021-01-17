package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.DataValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataValueDao {
    @Select("select * from t_datavalue where attId = #{attId}")
    List<DataValue> getDataByAttId(Integer attId);
    @Insert("insert into t_datavalue (value,valueCH,attId) value (#{value},#{valueCH},#{attId})")
    void add(DataValue dataValue);
    @Select("select * from t_datavalue where id = #{id}")
    DataValue getDataById(Integer id);
}
