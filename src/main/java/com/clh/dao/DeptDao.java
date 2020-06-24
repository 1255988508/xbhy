package com.clh.dao;

import com.clh.entity.Dept;
import com.clh.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 16:59
 * @Description
 */
public class DeptDao extends BaseDao {
    public List<Dept> listAll() {
        String sql = "select * from dept";
        return template.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }
}
