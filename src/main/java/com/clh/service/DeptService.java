package com.clh.service;

import com.clh.dao.DeptDao;
import com.clh.entity.Dept;

import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 18:10
 * @Description
 */
public class DeptService {
    private DeptDao deptDao=new DeptDao();
    public List<Dept> listAll(){
        return deptDao.listAll();
    }
}
