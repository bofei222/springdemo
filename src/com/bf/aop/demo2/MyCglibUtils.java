package com.bf.aop.demo2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author bofei
 * @date 2018/9/19 9:32
 */
public class MyCglibUtils {

    public static BookDaoImpl getProxy() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(BookDaoImpl.class);

//        Callback callback = null;

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("save")) {
                    System.out.println("日志...");
                }
                return methodProxy.invokeSuper(obj, args);
            }
        });
        BookDaoImpl bookDao = (BookDaoImpl) enhancer.create();
        return bookDao;
    }
}
