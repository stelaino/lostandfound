package com.qf.laf.controller;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Page;
import com.qf.laf.entity.Pickup;
import com.qf.laf.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/searchController")
public class SearchController {
    @Resource
    private ISearchService searchService;

    //首页或者寻物页搜索框通过省和相关内容进行搜索
    @PostMapping("/search1")
    public Page search1(HttpServletRequest request, @RequestBody Page page){
        //获取内容（关键字）
        String context = page.getContext();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        Page page1 = searchService.getLostListByContextAndProvince(province, context, currentPage);
        return page1;
    }

    //招领页搜索框通过省份和相关内容进行搜索
    @PostMapping("/search2")
    public Page search2(HttpServletRequest request, @RequestBody Page page){
        //获取内容（关键字）
        String context = page.getContext();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        Page page1 = searchService.getPickupListByContextAndProvince(province, context, currentPage);
        return page1;
    }

    //寻物页通过省份和类型进行筛选
    @PostMapping("/search3")
    public Page search3(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        Page page1 = searchService.getLostListByTypeAndProvince(province, type, currentPage);
        return page1;
    }

    //招领页通过省份和类型进行筛选
    @PostMapping("/search4")
    public Page search4(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        Page page1 = searchService.getPickupListByTypeAndProvince(province, type, currentPage);
        return page1;
    }


    //寻物页通过市和类型进行筛选
    @PostMapping("/search5")
    public Page search5(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取市
        String city = page.getCity();
        Page page1 = searchService.getLostListByTypeAndCity(city, type, currentPage);
        return page1;
    }

    //招领页通过市和类型进行筛选
    @PostMapping("/search6")
    public Page search6(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取市
        String city = page.getCity();
        Page page1 = searchService.getPickupListByTypeAndCity(city, type, currentPage);
        return page1;
    }

    //寻物页快速筛选框进行关键字搜索（没有选择市但是选择了类型（传递省，类型，关键字和当前页））
    @PostMapping("/search7")
    public Page search7(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取关键字
        String context = page.getContext();
        Page page1 = searchService.getLostListByTypeAndProvinceAndContext(province, type, context, currentPage);
        return page1;
    }

    //招领页快速筛选框进行关键字搜索（没有选择市但是选择了类型（传递省，类型，关键字和当前页））
    @PostMapping("/search8")
    public Page search8(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取关键字
        String context = page.getContext();
        Page page1 = searchService.getPickupListByTypeAndProvinceAndContext(province, type, context, currentPage);
        return page1;
    }

    //失物页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    @PostMapping("/search9")
    public Page search9(HttpServletRequest request, @RequestBody Page page){
        //获取市
        String city = page.getCity();
        //获取关键字
        String context = page.getContext();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        Page page1 = searchService.getLostListByContextAndCity(city, context, currentPage);
        return page1;
    }

    //招领页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
    @PostMapping("/search10")
    public Page search10(HttpServletRequest request, @RequestBody Page page){
        //获取市
        String city = page.getCity();
        //获取关键字
        String context = page.getContext();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        Page page1 = searchService.getPickupListByContextAndCity(city, context, currentPage);
        return page1;
    }

    //失物页面快速筛选框进行关键字搜索（选择了市也选择了类型（传市，类型，关键字，当前页））
    @PostMapping("/search11")
    public Page search11(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取市
        String city = page.getCity();
        //获取关键字
        String context = page.getContext();
        Page page1 = searchService.getLostListByTypeAndCityAndContext(city, type, context, currentPage);
        return page1;
    }

    //招领页面快速筛选框进行关键字搜索（选择了市也选择了类型（传市，类型，关键字，当前页））
    @PostMapping("/search12")
    public Page search12(HttpServletRequest request, @RequestBody Page page){
        //获取类型
        String type = page.getType();
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取市
        String city = page.getCity();
        //获取关键字
        String context = page.getContext();
        Page page1 = searchService.getPickupListByTypeAndCityAndContext(city, type, context, currentPage);
        return page1;
    }

    //点击失物帖子
    @PostMapping("/search13")
    public void search13(HttpServletRequest request, @RequestBody Lost lost){
        //获取lMsgId
        Integer lMsgId = lost.getLMsgId();
        System.out.println(lMsgId);
        request.getSession().setAttribute("lMsgId",lMsgId);
    }

    //点击招领帖子
    @PostMapping("/search14")
    public void search14(HttpServletRequest request, @RequestBody Pickup pickup){
        //获取pMsgId
        Integer pMsgId = pickup.getPMsgId();
        System.out.println(pMsgId);
        request.getSession().setAttribute("lMsgId",pMsgId);
    }
}
