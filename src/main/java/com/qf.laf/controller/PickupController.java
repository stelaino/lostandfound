package com.qf.laf.controller;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import com.qf.laf.service.IPickupService;
import com.qf.laf.utils.OssUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pickup")
public class PickupController {
    @Resource
    IPickupService pickupService;
    OssUtil ossUtil = new OssUtil();

    @PostMapping("/addPickupRow")
    @ResponseBody
    public Pickup addPickupRow(@RequestBody Pickup pickup) {
        System.out.println(pickup);
        Boolean b = pickupService.addPickupRow(pickup);
        return pickup;
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("img") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return ossUtil.uploadImg2Oss(file);
    }

    @RequestMapping("/checkTitle")
    public Map checkLostTitle(String title) {
        return pickupService.checkPickupTitle(title);
    }

    @RequestMapping("/getPickupListByUId")
    public List<Pickup> getPickupListByUId(HttpServletRequest request) {
        //模拟登录id
        Integer uId = (Integer) request.getSession().getAttribute("uId");
        return pickupService.getPickupListByUId(uId);
    }

    @PostMapping("/deletePickupByPMsgId")
    public String deletePickupByPMsgId(Integer pMsgId) {
        if (pickupService.deletePickupByPMsgId(pMsgId)) {
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("/updatePickup")
    public String updatePickup(@RequestBody Pickup pickup) {
        System.out.println(pickup);
        if (pickupService.updatePickup(pickup)) {
            return "修改成功";
        }
        return "修改失败";
    }

    @RequestMapping("/setUId")
    public String setUId(HttpServletRequest request, @RequestParam("uid") Integer uid) {
        request.getSession().setAttribute("uId", uid);
        return "设置成功";
    }

}
