package com.qf.laf.service;

import com.qf.laf.entity.Page;

public interface ISearchService {
    //通过省份和内容（关键字）获取失物信息
    Page getLostListByContextAndProvince(String province, String context, Integer currentPage);
    //通过省份和内容（关键字）获取招领信息
    Page getPickupListByContextAndProvince(String province, String context, Integer currentPage);

    //寻物页通过省份和类型进行筛选
    Page getLostListByTypeAndProvince(String province, String type, Integer currentPage);
    //招领页通过省份和类型进行筛选
    Page getPickupListByTypeAndProvince(String province, String type, Integer currentPage);

    //寻物页通过市和类型进行筛选
    Page getLostListByTypeAndCity(String city, String type, Integer currentPage);
    //招领页通过省份和类型进行筛选
    Page getPickupListByTypeAndCity(String city, String type, Integer currentPage);

    /*
        寻物页和招领页通过省份，类型，关键字进行搜索
    */
    //寻物页通过省份，类型，关键字进行搜索
    Page getLostListByTypeAndProvinceAndContext(String province, String type, String context, Integer currentPage);
    //招领页通过省份，类型，关键字进行搜索
    Page getPickupListByTypeAndProvinceAndContext(String province, String type, String context, Integer currentPage);


    /*
    *   失物和招领页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    * */
    //失物页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    Page getLostListByContextAndCity(String city, String context, Integer currentPage);
    //招领页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    Page getPickupListByContextAndCity(String city, String context, Integer currentPage);


    /*
        寻物页和招领页通过市，类型，关键字进行搜索
    */
    //寻物页通过市，类型，关键字进行搜索
    Page getLostListByTypeAndCityAndContext(String city, String type, String context, Integer currentPage);
    //招领页通过市，类型，关键字进行搜索
    Page getPickupListByTypeAndCityAndContext(String city, String type, String context, Integer currentPage);
}
