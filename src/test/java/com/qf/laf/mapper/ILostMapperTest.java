package com.qf.laf.mapper;

import com.qf.laf.container.BaseSpringTest;
import com.qf.laf.entity.Lost;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ILostMapperTest extends BaseSpringTest {
    @Resource
    ILostMapper iLostMapper;
    @Test
    public void testAddLostRow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Lost lost = new Lost();
        lost.setLProvince("远古大陆");
        lost.setLCity("天空之城");
        lost.setLAddress("丝绸之路");
        lost.setLTime(new Date(System.currentTimeMillis()));
        lost.setTitle("德玛西亚开始广播啦");
        lost.setType("三无产品");
        lost.setExpiration(new Date(System.currentTimeMillis()));
        lost.setBody("外卖人移动端机界面功能展示");
        lost.setPic1("https://static001.geekbang.org/resource/image/02/01/02434308bc9a3dab472d23aaac0cf301.jpg?x-oss-process=image/resize,m_fill,h_195,w_148");
        lost.setPic2("https://static001.geekbang.org/resource/image/8e/82/8e2269fd776c3c57ee96c52ad58ba382.jpg?x-oss-process=image/resize,m_fill,h_195,w_148");
        lost.setContact("小黄人");
        lost.setLPhone("18316610273");
        lost.setLEmail("18316610273@139.com");
        lost.setUId(1);
        lost.setVerifyStatus(1);
        Integer row = iLostMapper.addLostRow(lost);
        System.out.println();
    }

    @Test
    public void testCheckLostTitle() {
        System.out.println(iLostMapper.checkLostTitle("德玛西亚开始广播啦"));
    }
    @Test
    public void testGetLostByLMsgId() {
        System.out.println(iLostMapper.getLostByLMsgId(1));
    }
    @Test
    public void testGetLostListByUId() {
        System.out.println(iLostMapper.getLostListByUId(1));
    }

    @Test
    public void testSqlDate() {
        System.out.println(new java.sql.Date(System.currentTimeMillis()));
    }
}
