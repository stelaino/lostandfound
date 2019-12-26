package com.qf.laf.service.impl;

import com.qf.laf.entity.Page;
import com.qf.laf.mapper.IProvinceMapper;
import com.qf.laf.service.IProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Resource
    private IProvinceMapper provinceMapper;

    private Page page = new Page();

    @Override
    public Page getLostListByProvince(String province,Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = provinceMapper.getLostCount();
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setLostList(provinceMapper.getLostList((currentPage-1)*page.getNum(),page.getNum()));
            return page;
        }
        //省份不为全国时
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置省份
        page.setProvince(province);
        //给省份后面拼接一个省字
        province = province+"省";
        //获取该省数据总条数
        Integer dataCount = provinceMapper.getLostCountByProvince(province);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(provinceMapper.getLostListByProvince(province,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }


    @Override
    public Page getPickupListByProvince(String province,Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取招领数据总条数
            Integer dataCount = provinceMapper.getPickupCount();
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setPickupList(provinceMapper.getPickupList((currentPage-1)*page.getNum(),page.getNum()));
            return page;
        }
        //省份不为全国时
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置省份
        page.setProvince(province);
        //给省份后面拼接一个省字
        province = province+"省";
        //获取该省数据总条数
        Integer dataCount = provinceMapper.getPickupCountByProvince(province);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(provinceMapper.getPickupListByProvince(province,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }
}
