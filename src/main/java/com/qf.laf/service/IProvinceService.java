package com.qf.laf.service;

import com.qf.laf.entity.Page;

public interface IProvinceService {
    //通过省份获取该省份的失物信息
    Page getLostListByProvince(String province, Integer currentPage);
    //通过省份获取该省份的招领信息
    Page getPickupListByProvince(String province, Integer currentPage);
}
