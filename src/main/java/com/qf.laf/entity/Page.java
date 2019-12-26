package com.qf.laf.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    //当前页
    private Integer currentPage;
    //省份
    private String province;
    //城市
    private String city;
    //数据总条数
    private Integer dataCount;
    //页面总页数
    private Integer pageCount;
    //设置每页的数据条数
    private Integer num;
    //每页的寻物数据
    private List<Lost> lostList;
    //每页的招领数据
    private List<Pickup> pickupList;

    //内容（关键字）
    private String context;
    //类型
    private String type;
}
