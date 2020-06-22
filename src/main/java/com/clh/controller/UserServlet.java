package com.clh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auth chenlh
 * @data 2020/6/22 17:59
 * @Description
 */
//@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/jsp/user/list.jsp").forward(req,resp);
        String uri = req.getRequestURI();
        if (uri.endsWith("list")) {
            list(req, resp);
        }
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/user/list.jsp").forward(req, resp);
    }
}
