package com.fh.shopapi.dao;

import com.fh.shopapi.entity.po.Brand;
import com.fh.shopapi.entity.po.ShopData;
import com.fh.shopapi.entity.vo.PageParam2;
import org.apache.ibatis.annotations.Select;

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
}
