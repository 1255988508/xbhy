package com.clh.controller;

import com.alibaba.fastjson.JSON;
import com.clh.entity.Menu;
import com.clh.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auth chenlh
 * @data 2020/6/22 13:47
 * @Description
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private MenuService menuService = new MenuService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Menu> list = menuService.listAll();
        List<Menu> parent = new ArrayList<>();
        List<Menu> son = new ArrayList<>();
//        for (Menu m : list) {
//            if ("1".equals(m.getType())) {
//                parent.add(m);
//            }
//            if ("2".equals(m.getType())) {
//                son.add(m);
//            }
//        }
        parent = list.stream().filter(n -> {
            return "1".equals(n.getType());
        }).collect(Collectors.toList());

        son = list.stream().filter(n -> {
            return "2".equals(n.getType());
        }).collect(Collectors.toList());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
//        pw.write(JSON.toJSONString(parent));
//        pw.write(JSON.toJSONString(son));
        Map<String, List<Menu>> map = new HashMap<>();
        map.put("parent", parent);
        map.put("son", son);
        String strMap = JSON.toJSONString(map);
        pw.write(strMap);
        pw.flush();
        pw.close();
    }

//    @Override
//    protected void service2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Menu> list = menuService.listAll();
//        String strJson = JSON.toJSONString(list);
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter pw = resp.getWriter();
//        pw.write(strJson);
//        pw.flush();
//        pw.close();
//    }
}
