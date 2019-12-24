package com.qf.laf.mapper;

import com.qf.laf.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    Integer checkUserUId(@Param("user") User user);

    User getUserByUId(@Param("id") Integer id);
}
