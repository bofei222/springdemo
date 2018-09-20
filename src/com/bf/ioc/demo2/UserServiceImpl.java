package com.bf.ioc.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author bofei
 * @date 2018/9/18 15:52
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService {


    @Value(value = "美美")
    private String name;

//    @Autowired
//    @Qualifier(value = "ud") @Qualifier是限定符，要和@Autowired一起使用
    @Resource(name = "ud") // @Resource是Java注解，是name=""属性,Spring的是value=""属性
    private UserDao userDao;

    @Override
    public void sayHello() {
        System.out.println("Spring Hello!!" + name);
        userDao.save();

    }

//    @PostConstruct
//    public void init() {
//        System.out.println("初始化");
//    }




}
