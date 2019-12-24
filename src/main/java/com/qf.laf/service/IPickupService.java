package com.qf.laf.service;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;

import java.util.List;
import java.util.Map;

public interface IPickupService {
    Boolean addPickupRow(Pickup pickup);

    Map checkPickupTitle(String title);

    List<Pickup> getPickupListByUId(Integer uId);

    Boolean deletePickupByPMsgId(Integer pMsgId);

    Boolean updatePickup(Pickup pickup);
}
