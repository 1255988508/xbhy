package com.clh.controller;

import com.clh.service.CheckNameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @auth chenlh
 * @data 2020/6/23 19:50
 * @Description
 */
@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {
    private CheckNameService checkNameService = new CheckNameService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        checkNameService.checkName(name);

        if(checkNameService.checkName(name)&&name.toCharArray().length>0){
            writer.write("0");
        }else{
            writer.write("1");
        }
        writer.flush();
        writer.close();
    }
}
