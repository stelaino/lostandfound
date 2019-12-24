package com.qf.laf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Pickup {
    private Integer pMsgId;
    private String pProvince;
    private String pCity;
    private String pAddress;
    private Date pTime;
    private String title;
    private String type;
    private Date expiration;
    private String body;
    private String pic1;
    private String pic2;
    private String contact;
    private String pPhone;
    private String pEmail;
    private Integer uId;
    private Integer verifyStatus;
    private Date createTime;
    private Date modifyTime;
}
