package com.bf.aop.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author bofei
 * @date 2018/9/20 15:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class Demo3 {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;

    @Test
    public void run1() {
        customerDao.save();
        customerDao.update();
    }
}
