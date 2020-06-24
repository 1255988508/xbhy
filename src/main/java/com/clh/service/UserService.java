package com.clh.service;

import com.clh.dao.UserDao;
import com.clh.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 15:19
 * @Description
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> listAll(String name, Integer page) {
        return userDao.listAll(name, page);
    }
   /* public List<User> listAll() {
        return userDao.listAll();
    }*/

    public List<User> listByMessage(String name, Integer sex) {
        return userDao.listByMessage(name, sex);
    }

    public Integer getCount() {
        return userDao.getCount();
    }

    public void add(User user) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = df.format(date);
        user.setRegisterTime(date1);
        userDao.add(user);
    }

    public User toUpdate(Integer id) {
        return userDao.toUpdate(id);
    }

    public void update(User user) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = df.format(date);
        user.setRegisterTime(date1);
        userDao.update(user);
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }

    public Boolean listNAD(String name, Long id) {
        List<User> list = userDao.listNAD(name);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (!id.equals(list.get(i).getId())) {
                    return false;
                }
            }
        }
        return true;
    }
}
