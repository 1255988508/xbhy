package com.clh.dao;

import com.clh.utils.JBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @auth chenlh
 * @data 2020/6/22 13:41
 * @Description
 */
public class BaseDao {
    public JdbcTemplate template = new JdbcTemplate(JBUtil.getDruidDataSource());
}
