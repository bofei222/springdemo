package com.bf.aop.demo3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author bofei
 * @date 2018/9/20 15:53
 */
@Aspect
public class MyAspectAnno {

    @Pointcut(value = "execution(public * com.bf.aop.demo3.CustomerDaoImpl.save())")
    public void cutPoint() {

    }

    @Before(value = "MyAspectAnno.cutPoint()")
    public void log() {
        System.out.println("记录日志...");
    }

    /**
     * 最终通知：方法执行成功或者异常，都会执行
     */
    @After(value = "cutPoint()")
    public void after() {
        System.out.println("最终通知...");
    }

    @Around("cutPoint()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕1..");
        try {
            // 让目标对象的方法执行
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕2...");
    }

}
