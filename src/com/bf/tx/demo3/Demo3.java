package com.bf.tx.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author bofei
 * @date 2018/9/20 10:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class Demo3 {

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void run1() {
        accountService.transfer("冠希", "美美", 1000d);
    }
}
