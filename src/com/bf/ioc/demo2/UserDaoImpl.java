package com.bf.ioc.demo2;

import org.springframework.stereotype.Repository;

/**
 * @author bofei
 * @date 2018/9/20 14:35
 */
@Repository(value = "ud")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存客户...");
    }
}
