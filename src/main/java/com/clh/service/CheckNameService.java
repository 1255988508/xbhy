package com.clh.service;

import com.clh.dao.CheckNameDao;
import com.clh.entity.User;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 19:56
 * @Description
 */
public class CheckNameService {
    private CheckNameDao checkNameDao = new CheckNameDao();

    public boolean checkName(String name) {
        boolean flag = true;
        List<User> list = checkNameDao.checkName(name);
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getUsername())) {
                flag = false;
            }
        }
        return flag;
    }
}
