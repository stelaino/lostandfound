package com.qf.laf.mapper;

import com.qf.laf.entity.Report;
import org.apache.ibatis.annotations.Param;

public interface IReportMapper {
    int   addReport(@Param("report") Report report);

}
