package com.bf.aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bofei
 * @date 2018/9/18 13:32
 */
public class MyProxyUtils {
    public static UserDao getProxy(UserDao dao) {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("save")) {
                    System.out.println("开始事务");
                    Object invoke = method.invoke(dao, args);
                    System.out.println("结束事务");
                    return invoke;
                } else {

                    return method.invoke(dao, args);
                }
            }
        });

        return userDao;
    }
}
