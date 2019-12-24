package com.qf.laf.service.impl;

import com.qf.laf.entity.Administrator;
import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import com.qf.laf.mapper.IAdministratorMapper;
import com.qf.laf.service.IAdministratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministratorServiceImpl implements IAdministratorService {
    @Resource
    IAdministratorMapper administratorMapper;

    @Override
    public List<Lost> getNotVerityLost() {
        return administratorMapper.getNotVerityLost();
    }
    @Override
    public Boolean setLostEffective(Integer lMsgId) {
        if (administratorMapper.setLostEffective(lMsgId) > 0) {
            return true;
        }
        return false;
    }
    @Override
    public List<Pickup> getNotVerityPickup() {
        return administratorMapper.getNotVerityPickup();
    }

    @Override
    public Integer getAIdByAdministator(Administrator administrator) {
        return administratorMapper.getAIdByAdministator(administrator);
    }

    @Override
    public Boolean setPickupEffective(Integer pMsgId) {
        if (administratorMapper.setPickupEffective(pMsgId) > 0) {
            return true;
        }
        return false;
    }
}
