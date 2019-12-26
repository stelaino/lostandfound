package com.qf.laf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qf.laf.entity.Lost;
import com.qf.laf.mapper.ILostMapper;
import com.qf.laf.service.ILostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LostServiceImpl implements ILostService {

    @Resource
    ILostMapper lostMapper;

    @Override
    public Integer addLostRow(Lost lost) {
        return lostMapper.addLostRow(lost);
    }

    @Override
    public Map checkLostTitle(String title) {
        Map<String, Boolean> map = new HashMap<>();
        if (title != null && title.length() > 0&&lostMapper.checkLostTitle(title)>0) {
            map.put("valid",false);
                return map;
        }
        map.put("valid",true);
        return map;
    }

    @Override
    public List<Lost> getLostListByUId(Integer uId) {
        return lostMapper.getLostListByUId(uId);
    }

    @Override
    public Boolean deleteLostByLMsgId(Integer lMsgId) {
        Integer row = lostMapper.deleteLostByLMsgId(lMsgId);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateLost(Lost lost) {
        Integer row  = lostMapper.updateLost(lost);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Lost findLostById(Integer id) {
        return lostMapper.findLostById(id);
    }
}
