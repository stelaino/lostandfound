package com.qf.laf.service.impl;

import com.qf.laf.entity.Email;
import com.qf.laf.mapper.IEmailMapper;
import com.qf.laf.service.EmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: lostandfound->EmailServiceImpl
 * @author: peden
 * @create: 2019-12-24 23:35
 **/
@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    IEmailMapper emailMapper;

    @Override
    public int addEmail(Email email) {
        return  emailMapper.addEmail(email);
    }
}
