package com.qf.laf.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Lost {
    private Integer lMsgId;
    private String lProvince;
    private String lCity;
    private String lAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lTime;
    private String title;
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiration;
    private String body;
    private String pic1;
    private String pic2;
    private String contact;
    private String lPhone;
    private String lEmail;
    private Integer uId;
    private Integer verifyStatus;
    private Date createTime;
    private Date modifyTime;
}
