package com.qf.laf.vessel;

import com.qf.laf.container.BaseSpringTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class testVessel extends BaseSpringTest {

    @Test
    public void testLogger() {
        Logger logger = LoggerFactory.getLogger(testVessel.class);
        logger.info("这是一条测试用的日志");
        System.out.println(1);
    }
}
