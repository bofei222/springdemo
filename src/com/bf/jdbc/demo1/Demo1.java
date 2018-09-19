package com.bf.jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author bofei
 * @date 2018/9/19 12:46
 */
public class Demo1 {

    @Test
    public void run1() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///spring_day03");// ?
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(ds);

        template.update("INSERT INTO t_account VALUES (NULL, ?, ?)", "冠希", 10000);

    }
}
