package com.clh.controller;

import com.alibaba.fastjson.JSON;
import com.clh.entity.Dept;
import com.clh.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auth chenlh
 * @data 2020/6/23 18:15
 * @Description
 */
@WebServlet("/dept")
public class DeptServlet extends HttpServlet {
    private DeptService deptService=new DeptService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> list = deptService.listAll();
        resp.getWriter().write(JSON.toJSONString(list));
    }
}
