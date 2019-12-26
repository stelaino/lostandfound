package com.qf.laf.service.impl;

import com.qf.laf.entity.Page;
import com.qf.laf.mapper.ISearchMapper;
import com.qf.laf.service.ISearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SearchSeviceImpl implements ISearchService {
    @Resource
    private ISearchMapper searchMapper;

    private Page page  = new Page();

    //首页或者寻物页搜索栏
    @Override
    public Page getLostListByContextAndProvince(String province, String context, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getLostCountByContext(context);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setLostList(searchMapper.getLostListByContext((currentPage-1)*page.getNum(),page.getNum(),context));
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
        Integer dataCount = searchMapper.getLostCountByContextAndProvince(province,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByContextAndProvince(province,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页搜索栏
    @Override
    public Page getPickupListByContextAndProvince(String province, String context, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getPickupCountByContext(context);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setPickupList(searchMapper.getPickupListByContext((currentPage-1)*page.getNum(),page.getNum(),context));
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
        Integer dataCount = searchMapper.getPickupCountByContextAndProvince(province,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByContextAndProvince(province,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //寻物页通过省份和类型筛选
    @Override
    public Page getLostListByTypeAndProvince(String province, String type, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getLostCountByType(type);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setLostList(searchMapper.getLostListByType((currentPage-1)*page.getNum(),page.getNum(),type));
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
        Integer dataCount = searchMapper.getLostCountByTypeAndProvince(province,type);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByTypeAndProvince(province,type,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页通过省份和类型筛选
    @Override
    public Page getPickupListByTypeAndProvince(String province, String type, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getPickupCountByType(type);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setPickupList(searchMapper.getPickupListByType((currentPage-1)*page.getNum(),page.getNum(),type));
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
        Integer dataCount = searchMapper.getPickupCountByTypeAndProvince(province,type);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByTypeAndProvince(province,type,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //寻物页通过市和类型进行筛选
    @Override
    public Page getLostListByTypeAndCity(String city, String type, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给市后面拼接一个市字
        city = city+"市";
        //获取该市数据总条数
        Integer dataCount = searchMapper.getLostCountByTypeAndCity(city, type);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByTypeAndCity(city,type,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页通过市和类型进行筛选
    @Override
    public Page getPickupListByTypeAndCity(String city, String type, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给市后面拼接一个市字
        city = city+"市";
        //获取该市数据总条数
        Integer dataCount = searchMapper.getPickupCountByTypeAndCity(city, type);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByTypeAndCity(city,type,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //寻物页通过省份，类型，关键字进行搜索
    @Override
    public Page getLostListByTypeAndProvinceAndContext(String province, String type, String context, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getLostCountByTypeAndContext(type,context);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setLostList(searchMapper.getLostListByTypeAndContext((currentPage-1)*page.getNum(),page.getNum(),type,context));
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
        Integer dataCount = searchMapper.getLostCountByTypeAndProvinceAndContext(province,type,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByTypeAndProvinceAndContext(province,type,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页通过省份，类型，关键字进行搜索
    @Override
    public Page getPickupListByTypeAndProvinceAndContext(String province, String type, String context, Integer currentPage) {
        //省份为全国时
        if(province.equals("全国")){
            //设置当前页
            page.setCurrentPage(currentPage);
            //设置省份
            page.setProvince("全国");
            //获取失物数据总条数
            Integer dataCount = searchMapper.getPickupCountByTypeAndContext(type,context);
            //设置每页数据条数
            page.setNum(9);
            //获取设置总页数
            page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
            //获取每页数据
            page.setPickupList(searchMapper.getPickupListByTypeAndContext((currentPage-1)*page.getNum(),page.getNum(),type,context));
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
        Integer dataCount = searchMapper.getPickupCountByTypeAndProvinceAndContext(province,type,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByTypeAndProvinceAndContext(province,type,(currentPage-1)*page.getNum(),page.getNum(),context));
        return page;
    }

    //失物页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    @Override
    public Page getLostListByContextAndCity(String city, String context, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给省份后面拼接一个市字
        city = city+"市";
        //获取该市数据总条数
        Integer dataCount = searchMapper.getLostCountByContextAndCity(city,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByContextAndCity(city,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    @Override
    public Page getPickupListByContextAndCity(String city, String context, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给省份后面拼接一个市字
        city = city+"市";
        //获取该省数据总条数
        Integer dataCount = searchMapper.getPickupCountByContextAndCity(city,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByContextAndCity(city,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //寻物页通过市，类型，关键字进行搜索
    @Override
    public Page getLostListByTypeAndCityAndContext(String city, String type, String context, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给市后面拼接一个市字
        city = city+"市";
        //获取该省数据总条数
        Integer dataCount = searchMapper.getLostCountByTypeAndCityAndContext(city,type,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setLostList(searchMapper.getLostListByTypeAndCityAndContext(city,type,context,(currentPage-1)*page.getNum(),page.getNum()));
        return page;
    }

    //招领页通过市，类型，关键字进行搜索
    @Override
    public Page getPickupListByTypeAndCityAndContext(String city, String type, String context, Integer currentPage) {
        //设置当前页
        page.setCurrentPage(currentPage);
        //设置市
        page.setCity(city);
        //给市后面拼接一个市字
        city = city+"市";
        //获取该省数据总条数
        Integer dataCount = searchMapper.getPickupCountByTypeAndCityAndContext(city,type,context);
        //设置每页数据条数
        page.setNum(9);
        //获取设置总页数
        page.setPageCount(dataCount%page.getNum() == 0? dataCount/page.getNum():dataCount/page.getNum()+1 );
        //获取每页数据
        page.setPickupList(searchMapper.getPickupListByTypeAndCityAndContext(city,type,(currentPage-1)*page.getNum(),page.getNum(),context));
        return page;
    }

}
