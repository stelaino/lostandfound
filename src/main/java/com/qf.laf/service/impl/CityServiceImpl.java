package com.qf.laf.service.impl;

import com.qf.laf.entity.Page;
import com.qf.laf.mapper.ICityMapper;
import com.qf.laf.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements ICityService {
    @Resource
    private ICityMapper cityMapper;
    private Page page = new Page();

    @Override
    public Page getLostListByCity(String province, Integer currentPage, String city) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置城市
        page.setCity(city);
        //给省份后面拼接一个省字
        province = province+"省";
        //在市后面拼接一个市
        city = city + "市";
        //获取该城市数据总条数
        Integer count = cityMapper.getLostCountByCity(province, city);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(count%page.getNum() == 0? count/page.getNum():count/page.getNum()+1 );
        //获取每页数据
        page.setLostList(cityMapper.getLostListByCity(province,city,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    @Override
    public Page getPickupListByCity(String province, Integer currentPage, String city) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置城市
        page.setCity(city);
        //给省份后面拼接一个省字
        province = province+"省";
        //在市后面拼接一个市
        city = city + "市";
        //获取该城市数据总条数
        Integer count = cityMapper.getPickupCountByCity(province, city);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(count%page.getNum() == 0? count/page.getNum():count/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(cityMapper.getPickupListByCity(province,city,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }
}
