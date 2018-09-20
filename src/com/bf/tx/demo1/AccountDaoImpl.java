package com.bf.tx.demo1;

import com.bf.tx.demo1.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author bofei
 * @date 2018/9/20 9:40
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void outMoney(String from, Double money) {
        this.getJdbcTemplate().update("UPDATE t_account SET money = money - ? WHERE name = ?", money, from);

    }

    @Override
    public void inMoney(String to, Double money) {
        this.getJdbcTemplate().update("UPDATE t_account SET money = money + ? WHERE name = ?", money, to );
    }

}
