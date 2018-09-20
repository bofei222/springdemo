package com.bf.aop.demo3;

/**
 * @author bofei
 * @date 2018/9/20 15:46
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save() {
        System.out.println("保存..");
    }

    @Override
    public void update() {
        System.out.println("修改...");
    }
}
