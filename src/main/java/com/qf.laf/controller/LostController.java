package com.qf.laf.controller;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import com.qf.laf.service.ILostService;
import com.qf.laf.utils.OssUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lost")
public class LostController {
    @Resource
    ILostService lostService;
    OssUtil ossUtil = new OssUtil();

    @PostMapping("/addLostRow")
    @ResponseBody
    public Lost addLostRow(@RequestBody Lost lost, HttpServletRequest request) {
        Integer uId = (Integer) request.getSession().getAttribute("uId");
        lost.setUId(uId);
        System.out.println(lost);
        lostService.addLostRow(lost);
        return lost;
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("img") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return ossUtil.uploadImg2Oss(file);
    }

    @RequestMapping("/checkTitle")
    public Map checkLostTitle(String title) {
        return lostService.checkLostTitle(title);
    }

    @RequestMapping("/getLostListByUId")
    public List<Lost> getLostListByUId(HttpSession session) {
        //模拟登录id
        Integer uId = (Integer) session.getAttribute("uId");
        return lostService.getLostListByUId(uId);
    }

    @PostMapping("/deleteLostByLMsgId")
    public String deleteLostByLMsgId(Integer lMsgId) {
        if (lostService.deleteLostByLMsgId(lMsgId)) {
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("/updateLost")
    public String updateLost(@RequestBody Lost lost) {
        System.out.println(lost);
        if (lostService.updateLost(lost)) {
            return "修改成功";
        }
        return "修改失败";
    }
    @RequestMapping(value = "/getLost")
    public Lost  getLost(HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer lMsgId =(Integer) session.getAttribute("lMsgId");
        Lost lost = lostService.findLostById(lMsgId);
        System.out.println(lost);
        return  lost;
    }
}
