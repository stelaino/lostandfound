package com.qf.laf.service.impl;

import com.qf.laf.entity.Pickup;
import com.qf.laf.mapper.IPickupMapper;
import com.qf.laf.service.IPickupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PickupServiceImpl implements IPickupService {
    @Resource
    IPickupMapper pickupMapper;

    @Override
    public Boolean updatePickup(Pickup pickup) {
        Integer row  = pickupMapper.updatePickup(pickup);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Map checkPickupTitle(String title) {
        Map<String, Boolean> map = new HashMap<>();
        if (title != null && title.length() > 0&&pickupMapper.checkPickupTitle(title)>0) {
            map.put("valid",false);
            return map;
        }
        map.put("valid",true);
        return map;
    }

    @Override
    public List<Pickup> getPickupListByUId(Integer uId) {
        return pickupMapper.getPickupListByUId(uId);
    }

    @Override
    public Boolean deletePickupByPMsgId(Integer pMsgId) {
        Integer row = pickupMapper.deletePickupByPMsgId(pMsgId);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addPickupRow(Pickup pickup) {
        if (pickupMapper.addPickupRow(pickup) > 0) {
            return true;
        }
        return false;
    }
}
