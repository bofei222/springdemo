package com.bf.aop.demo1;

/**
 * @author bofei
 * @date 2018/9/18 10:58
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl.save");
    }

    @Override
    public void update() {
        System.out.println("UserDaoImpl.update");
    }
}
