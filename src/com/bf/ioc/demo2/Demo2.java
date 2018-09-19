package com.bf.ioc.demo2;

import com.bf.aop.demo2.BookDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bofei
 * @date 2018/9/18 15:52
 */
public class Demo2 {

    @Test
    public void run1() {
        UserService us = new UserServiceImpl();
        us.sayHello();
    }

    @Test
    public void run2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = ac.getBean("userService", UserService.class);
        us.sayHello();


    }

}
