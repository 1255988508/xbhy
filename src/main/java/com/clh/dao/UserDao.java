package com.clh.dao;

import com.clh.entity.User;
import com.clh.utils.JBUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 15:12
 * @Description
 */
public class UserDao extends BaseDao {
    public List<User> listAll(String name, Integer page) {
        String sql = "select * from user where username like ? limit ?,5";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + name + "%", page);
    }
    /*public List<User> listAll2() {
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }*/

    public Integer getCount() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql, Integer.class);
    }

    public List<User> listByMessage(String name, Integer sex) {
        String sql = "SELECT * from user where username like ?";
        if (sex != -1) {
            sql = "SELECT * from user where username like ? and sex=?";
            return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + name + "%", sex);
        }
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + name + "%");
    }

    public void add(User user) {
        String sql = "insert into user(username,password,email,real_name,age,sex,description,register_time,dept_id) values(?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRealName(), user.getAge(), user.getSex(), user.getDescription(), user.getRegisterTime(), user.getDeptId());
    }

    public void update(User user) {
        String sql = "update user set username=?,password=?,real_name=?,age=?,sex=?,description=?,register_time=?,dept_id=? where id=?";
        template.update(sql, user.getUsername(), user.getPassword(), user.getRealName(), user.getAge(), user.getSex(), user.getDescription(), user.getRegisterTime(), user.getDeptId(), user.getId());
    }

    public User toUpdate(Integer id) {
        String sql = "select * from user where id=?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }
    public List<User> listNAD(String name) {
        String sql = "select username from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
