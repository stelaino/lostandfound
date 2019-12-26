package com.qf.laf.controller;

import com.qf.laf.entity.Email;
import com.qf.laf.service.EmailService;
import com.qf.laf.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: lostandfound->EmailController
 * @author: peden
 * @create: 2019-12-24 18:01
 **/

@Slf4j
@RestController
@RequestMapping("EmailController")
public class EmailController {

    @Resource
    EmailService emailService;

    @PostMapping( value = "addEmail")
    public  int addEmail(@RequestBody Email email){
        System.out.println(email);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MailUtils.sendMail(email.getEAddress(), email.getBody(), "来自网络失误招领平台的信息");
            }
        }).start();
//        boolean b = MailUtils.sendMail(email.getEAddress(), email.getBody(), "来自网络失误招领平台的信息");
//        if (b=true){
//            System.out.println("发送成功");
//        }else {
//            System.out.println("发送失败");
//        }
        return emailService.addEmail(email);
    }
}
