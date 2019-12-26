package com.qf.laf.controller;

import com.qf.laf.entity.Page;
import com.qf.laf.service.ICityService;
import com.qf.laf.service.IProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/provinceController")
public class ProvinceController {
    @Resource
    private IProvinceService provinceService;
    @Resource
    private ICityService cityService;

    //首页刷新或者第一次进入首页
    @PostMapping("/getList1")
    public Page getList1(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取传入的省份
        String province = page.getProvince();
        //获取作用域中省份的值
        String province1 = (String)request.getSession().getAttribute("province");
        //先判断作用域中的值是否为空，不为空则通过该作用域的值作为省份进行查询，如果为空（一般为第一次进入首页则用全国）
        if(province1 != null){
            Page page1 = provinceService.getLostListByProvince(province1,currentPage);
            return page1;
        }
        //session作用域中的值为空时
        Page page1 = provinceService.getLostListByProvince(province,currentPage);
        return page1;
    }

    //招领页
    @PostMapping("/getList4")
    public Page getList4(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取传入的省份
        String province = page.getProvince();
        //获取作用域中省份的值
        String province1 = (String)request.getSession().getAttribute("province");
        //先判断作用域中的值是否为空，不为空则通过该作用域的值作为省份进行查询，如果为空（一般为第一次进入首页则用全国）
        if(province1 != null){
            Page page1 = provinceService.getPickupListByProvince(province1,currentPage);
            return page1;
        }
        //session作用域中的值为空时
        Page page1 = provinceService.getPickupListByProvince(province,currentPage);
        return page1;
    }

    //点击选择省份
    @PostMapping("/getList2")
    public Page getList2(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //将省份信息放入作用域中
        request.getSession().setAttribute("province",province);
        //通过传进来的省份进行查询
        Page page1 = provinceService.getLostListByProvince(province, currentPage);
        return page1;
    }

    //招领点击选择省份
    @PostMapping("/getList3")
    public Page getList3(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //将省份信息放入作用域中
        request.getSession().setAttribute("province",province);
        //通过传进来的省份进行查询
        Page page1 = provinceService.getPickupListByProvince(province, currentPage);
        return page1;
    }

    //进入寻物页面
    @PostMapping("/getLostList1")
    public Page getLostList1(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取省份作用域中的值
        String province1 = (String) request.getSession().getAttribute("province");
        //判断是否为空，为空则表示为全国，不为空则查该省份的失物表
        if(province1 != null){
            Page page1 = provinceService.getLostListByProvince(province1, currentPage);
            return page1;
        }
        //session作用域中的值为空时
        Page page1 = provinceService.getLostListByProvince(province,currentPage);
        return page1;
    }

    //进入招领页面
    @PostMapping("/getPickupList1")
    public Page getPickupList1(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取省份作用域中的值
        String province1 = (String) request.getSession().getAttribute("province");
        //判断是否为空，为空则表示为全国，不为空则查该省份的招领表
        if(province1 != null){
            Page page1 = provinceService.getPickupListByProvince(province1, currentPage);
            return page1;
        }
        //session作用域中的值为空时
        Page page1 = provinceService.getPickupListByProvince(province,currentPage);
        return page1;
    }

    //寻物选择城市
    @PostMapping("/getLostList2")
    public Page getLostList2(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取城市
        String city = page.getCity();
        //将城市放入作用域中
        request.getSession().setAttribute("city",city);
        Page page1 = cityService.getLostListByCity(province, currentPage, city);
        return page1;
    }

    //招领选择城市
    @PostMapping("/getPickupList2")
    public Page getPickupList2(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取城市
        String city = page.getCity();
        //将城市放入作用域中
        request.getSession().setAttribute("city",city);
        Page page1 = cityService.getPickupListByCity(province, currentPage, city);
        return page1;
    }

    //寻物点击跳转页面
    @PostMapping("/getLostList3")
    public Page getLostList3(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取城市
        String city = page.getCity();
        //获取作用域中的城市
        String city1 = (String)request.getSession().getAttribute("city");
        Page page1 = cityService.getLostListByCity(province, currentPage, city1);
        return page1;
    }

    //招领点击跳转页面
    @PostMapping("/getPickupList3")
    public Page getPickupList3(HttpServletRequest request, @RequestBody Page page){
        //获取当前页
        Integer currentPage = page.getCurrentPage();
        //获取省份
        String province = page.getProvince();
        //获取城市
        String city = page.getCity();
        //获取作用域中的城市
        String city1 = (String)request.getSession().getAttribute("city");
        Page page1 = cityService.getPickupListByCity(province, currentPage, city1);
        return page1;
    }
}
