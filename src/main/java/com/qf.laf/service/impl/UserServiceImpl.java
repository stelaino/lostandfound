package com.qf.laf.service.impl;

import com.qf.laf.entity.User;
import com.qf.laf.mapper.IUserMapper;
import com.qf.laf.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    IUserMapper userMapper;

    @Override
    public User getUserByUId(int id) {
        return userMapper.getUserByUId(id);
    }

    @Override
    public Integer login(User user) {
        return userMapper.checkUserUId(user);
    }
}
