package com.bf.aop.demo2;

import org.junit.Test;

/**
 * @author bofei
 * @date 2018/9/19 9:22
 */
public class Demo2 {

    @Test
    public void run1() {
        BookDaoImpl bdi = new BookDaoImpl();
        bdi.update();
        bdi.save();
        System.out.println("*******************");
    }

    @Test
    public void run2() {
        BookDaoImpl proxy = MyCglibUtils.getProxy();

        proxy.save();
        proxy.update();
    }

}
