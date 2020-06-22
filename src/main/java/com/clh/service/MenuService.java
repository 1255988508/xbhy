package com.clh.service;

import com.clh.dao.MenuDao;
import com.clh.entity.Menu;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/22 13:46
 * @Description
 */
public class MenuService {
    private MenuDao menuDao=new MenuDao();
    public List<Menu> listAll(){
        return menuDao.listAll();
    }
}
