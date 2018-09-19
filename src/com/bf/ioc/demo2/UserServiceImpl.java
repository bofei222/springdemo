package com.bf.ioc.demo2;

import org.springframework.stereotype.Component;

/**
 * @author bofei
 * @date 2018/9/18 15:52
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public void sayHello() {
        System.out.println("Spring Hello!!");
    }


}
