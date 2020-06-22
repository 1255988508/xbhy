package com.clh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auth chenlh
 * @data 2020/6/22 18:30
 * @Description
 */

@WebServlet("/user/*")
public class User2Servlet extends BaseServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("开始了");
//    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("list");
        req.getRequestDispatcher("/jsp/user/list.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
    }
}
