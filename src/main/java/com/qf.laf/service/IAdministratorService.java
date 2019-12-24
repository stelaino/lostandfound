package com.qf.laf.service;

import com.qf.laf.entity.Administrator;
import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;

import java.util.List;

public interface IAdministratorService {
    /**
     * 通过失物贴的审核
     * @param lMsgId
     * @return
     */
    Boolean setLostEffective(Integer lMsgId);

    List<Lost> getNotVerityLost();

    Boolean setPickupEffective(Integer pMsgId);

    List<Pickup> getNotVerityPickup();

    Integer getAIdByAdministator(Administrator administrator);
}
