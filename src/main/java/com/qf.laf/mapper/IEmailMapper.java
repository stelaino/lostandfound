package com.qf.laf.mapper;

import com.qf.laf.entity.Email;
import org.apache.ibatis.annotations.Param;

public interface IEmailMapper {
     int  addEmail(@Param("email") Email email);
}
