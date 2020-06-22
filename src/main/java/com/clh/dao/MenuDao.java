package com.clh.dao;

import com.clh.entity.Menu;
import com.clh.utils.JBUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/22 13:36
 * @Description
 */
public class MenuDao extends BaseDao {
    public List<Menu> listAll() {
        String sql = "select * from sys_menu";
        return template.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class));
    }

}
