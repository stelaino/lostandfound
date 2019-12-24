package com.qf.laf.service;

import com.qf.laf.entity.Lost;

import java.util.List;
import java.util.Map;

public interface ILostService {
    /**
     *丢失信息贴的写入
     * @param lost
     * @return
     */
    public Integer addLostRow(Lost lost);

    /**
     * 查询相同的帖名是否存在
     * @param title
     * @return
     */
    Map checkLostTitle(String title);

    /**
     * 根据用户的id查询用户发送的有效帖子
     * @param uId
     * @return
     */
    List<Lost> getLostListByUId(Integer uId);

    /**
     * 通过失物帖子的id删除数据
     * @param lMsgId
     * @return 返回true表示删除成功，返回false表示删除失败
     */
    Boolean deleteLostByLMsgId(Integer lMsgId);

    /**
     * 修改数据，如果修改成功返回true，如果修改失败返回false
     * @param lost
     * @return
     */
    Boolean updateLost(Lost lost);
}
