package com.qf.laf.mapper;

import com.qf.laf.entity.Pickup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPickupMapper {
    Integer addPickupRow(@Param("pickup") Pickup pickup);

    Integer checkPickupTitle(@Param("title") String title);

    List<Pickup> getPickupListByUId(@Param("uId") Integer uId);

    Integer deletePickupByPMsgId(@Param("pMsgId") Integer pMsgId);

    Integer updatePickup(@Param("pickup") Pickup pickup);

    //通过id查找招领信息
    Pickup  findPickupById(@Param("id") int id);
}
