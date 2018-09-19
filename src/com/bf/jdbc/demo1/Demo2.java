package com.bf.jdbc.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bofei
 * @date 2018/9/19 15:33
 * 测试JDBC的模板，使用IOC的方式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void run1() {
        jdbcTemplate.update("INSERT INTO t_account VALUES (NULL, ?, ?)", "小苍", 10000);
    }

    /**
     * 可以完成增、删、改
     * 修改
     */
    @Test
    public void run2() {
        jdbcTemplate.update("UPDATE t_account SET name = ? WHERE id = ?", "熊大", 4);
    }

    /**
     * 删除
     */
    @Test
    public void run3() {
        jdbcTemplate.update("DELETE FROM t_account WHERE id = ?", 4);
    }


    /**
     * 查询:通过主键查询一条记录
     */
    @Test
    public void run4() {
        Account account = jdbcTemplate.queryForObject("Select * FROM t_account WHERE id = ?", new BeanMapper(), 1);
        System.out.println(account);
    }

    @Test
    public void run5() {
        List<Account> query = jdbcTemplate.query("SELECT * FROM t_account", new BeanMapper());
        System.out.println(query);
    }
}


/**
 * 自己手动的来封装（一行一行封装数据）
 */
class BeanMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account ac = new Account();
        ac.setId(rs.getInt("id"));
        ac.setName(rs.getString("name"));
        ac.setMoney(rs.getDouble("money"));
        return ac;
    }
}
