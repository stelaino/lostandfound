package com.qf.laf.mapper;

import com.qf.laf.entity.Lost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILostMapper {
    Integer addLostRow(@Param("lost") Lost lost);

    Integer checkLostTitle(@Param("title") String title);

    Lost getLostByLMsgId(@Param("lMsgId")Integer lMsgId);

    List<Lost> getLostListByUId(@Param("uId") Integer uId);

    Integer deleteLostByLMsgId(@Param("lMsgId") Integer lMsgId);

    Integer updateLost(@Param("lost") Lost lost);

    //通过用户ID查询寻物信息2
    Lost findLostById(@Param(value = "id") Integer id);
}
