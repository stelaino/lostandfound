package com.qf.laf.mapper;

import com.qf.laf.entity.Administrator;
import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdministratorMapper {

    Integer setLostEffective(@Param("lMsgId") Integer lMsgId);

    List<Lost> getNotVerityLost();

    Integer setPickupEffective(@Param("pMsgId") Integer pMsgId);

    List<Pickup> getNotVerityPickup();

    Integer getAIdByAdministator(@Param("admin")Administrator administrator);
}
