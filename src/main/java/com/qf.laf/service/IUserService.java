package com.qf.laf.service;

import com.qf.laf.entity.User;

public interface IUserService {
    Integer login(User user);
    User getUserByUId(int id);
    Integer register(User user);
    void sendMail(String email,String code);
}
