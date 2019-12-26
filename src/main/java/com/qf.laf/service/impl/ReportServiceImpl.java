package com.qf.laf.service.impl;

import com.qf.laf.entity.Report;
import com.qf.laf.mapper.IReportMapper;
import com.qf.laf.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: lostandfound->ReportServiceImpl
 * @author: peden
 * @create: 2019-12-24 21:36
 **/

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    IReportMapper reportMapper;
    @Override
    public int addReport(Report report) {
       return reportMapper.addReport(report);
    }
}
