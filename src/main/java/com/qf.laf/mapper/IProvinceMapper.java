package com.qf.laf.mapper;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProvinceMapper {
    //获取全国失物信息
    List<Lost> getLostList(@Param("offset") Integer offset, @Param("num") Integer num);
    //获取全国失物信息总条数
    Integer getLostCount();
    //获取全国招领信息
    List<Pickup> getPickupList(@Param("offset") Integer offset, @Param("num") Integer num);
    //获取全国寻物信息总条数
    Integer getPickupCount();

    //通过省份获取该省份的失物信息
    List<Lost> getLostListByProvince(@Param("lProvince") String lProvince, @Param("offset") Integer offset, @Param("num") Integer num);
    //获取该省寻物数据总条数
    Integer getLostCountByProvince(@Param("lProvince") String lProvince);
    //通过省份获取该省份的招领信息
    List<Pickup> getPickupListByProvince(@Param("lProvince") String lProvince, @Param("offset") Integer offset, @Param("num") Integer num);
    //获取该省招领数据总条数
    Integer getPickupCountByProvince(@Param("lProvince") String lProvince);
}
