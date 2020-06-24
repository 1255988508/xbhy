package com.clh.dao;

import com.clh.entity.Dept;
import com.clh.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 19:51
 * @Description
 */
public class CheckNameDao extends BaseDao {

    public List<User> checkName(String name) {
        String sql = "select username from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
