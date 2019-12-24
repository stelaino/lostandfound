package com.qf.laf.controller;

import com.qf.laf.entity.Administrator;
import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import com.qf.laf.service.IAdministratorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdminController {
    @Resource
    IAdministratorService administratorService;

    @RequestMapping("/login")
    public Boolean administratorLogin(@RequestBody Administrator administrator) {
        System.out.println(administrator);
        if (administrator != null) {
            Integer aId = administratorService.getAIdByAdministator(administrator);
            if (aId != null) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/getNotVerityLost")
    public List<Lost> getNotVerityLost() {
        return administratorService.getNotVerityLost();
    }

    @RequestMapping("/censorLost")
    public String censorLost(Integer lMsgId) {
        if (administratorService.setLostEffective(lMsgId)) {
            return "审核成功";
        }
        return "审核失败";
    }

    @RequestMapping("/getNotVerityPickup")
    public List<Pickup> getNotVerityPickup() {
        return administratorService.getNotVerityPickup();
    }

    @RequestMapping("/censorPickup")
    public String censorPickup(Integer pMsgId) {
        if (administratorService.setPickupEffective(pMsgId)) {
            return "审核成功";
        }
        return "审核失败";
    }

    @RequestMapping("/setUId")
    public String setUId(HttpServletRequest request, @RequestParam("lMsgId") Integer lMsgId) {
        request.getSession().setAttribute("lMsgId", lMsgId);
        return "设置成功";
    }
}
