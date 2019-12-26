package com.qf.laf.mapper;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICityMapper {
    //获取该城市失物数据
    List<Lost> getLostListByCity(@Param("province") String province, @Param("city") String city, @Param("offset") Integer offset, @Param("num") Integer num);
    //获取该城市的失物数据总条数
    Integer getLostCountByCity(@Param("province") String province, @Param("city") String city);
    //获取该城市招领数据
    List<Pickup> getPickupListByCity(@Param("province") String province, @Param("city") String city, @Param("offset") Integer offset, @Param("num") Integer num);
    //获取该城市的招领数据总条数
    Integer getPickupCountByCity(@Param("province") String province, @Param("city") String city);
}
