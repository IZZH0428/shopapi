package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.DataValue;
import org.apache.ibatis.annotations.Select;

public interface DataValueDao {
    @Select("select * from t_datavalue where attId = #{attId}")
    DataValue getDataByAttId(Integer attId);
}
