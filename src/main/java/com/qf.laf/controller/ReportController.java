package com.qf.laf.controller;


import com.qf.laf.entity.Report;
import com.qf.laf.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: lostandfound->reportController
 * @author: peden
 * @create: 2019-12-21 10:12
 **/
@Slf4j
@RestController
@RequestMapping("/reportController")
public class ReportController {

    @Resource
    ReportService reportService;

            @PostMapping( value = "/addReport")
            public  int  addReport(@RequestBody Report report){
//                public  int  addReport(@RequestBody String report){
                return    reportService.addReport(report);
            }
}
