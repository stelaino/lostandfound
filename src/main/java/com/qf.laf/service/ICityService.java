package com.qf.laf.service;

import com.qf.laf.entity.Page;

public interface ICityService {
    //通过城市获取失物信息
    Page getLostListByCity(String province, Integer currentPage, String city);
    //通过城市获取招领信息
    Page getPickupListByCity(String province, Integer currentPage, String city);
}
