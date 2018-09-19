package com.bf.ioc.demo1;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author bofei
 * @date 2018/9/18 15:37
 */
public class Demo1 {

    private Logger log = Logger.getLogger(Demo1.class);

    @Test
    public void run1() {
        System.out.println("执行了...");
        log.info("执行了...");
    }
}
