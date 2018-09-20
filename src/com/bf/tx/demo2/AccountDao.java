package com.bf.tx.demo2;

/**
 * @author bofei
 * @date 2018/9/20 9:39
 */
public interface AccountDao {
    void outMoney(String from, Double money);
    void inMoney(String to, Double money);
}
