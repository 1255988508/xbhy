package com.clh.controller;

import com.alibaba.fastjson.JSON;
import com.clh.entity.Dept;
import com.clh.entity.User;
import com.clh.service.DeptService;
import com.clh.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
    private UserService userService = new UserService();
    private DeptService deptService = new DeptService();

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            name = "";
        }
        Integer count = userService.getCount();
        Integer pageCount = count % 5 == 0 ? count / 5 : count / 5 + 1;
        String pageStr = req.getParameter("page");
        Integer page = 1;
        if (!StringUtils.isEmpty(pageStr)) {
            page = Integer.valueOf(pageStr);
            if (page <= 0) {
                page = 1;
            }
            if (page >= pageCount) {
                page = pageCount;
            }
        }
        List<User> list = userService.listAll(name, page - 1);
        req.setAttribute("list", list);
        req.setAttribute("count", count);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/jsp/user/list.jsp").forward(req, resp);
    }

    public void listByMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Integer sex = Integer.valueOf(req.getParameter("sex"));
        if (StringUtils.isEmpty(username)) {
            username = "";
        }
        List<User> list = userService.listByMessage(username, sex);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/jsp/user/list.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.add(user);
        resp.sendRedirect("/user/list");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Integer id = Integer.valueOf(idStr);
        userService.delete(id);
        resp.sendRedirect("user/list");
    }

    public void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Integer id = Integer.valueOf(idStr);
        if (!StringUtils.isEmpty(id)) {
            User user = userService.toUpdate(id);
            List<Dept> list = deptService.listAll();
            req.setAttribute("deptList", list);
            req.setAttribute("user", user);

        }
        req.getRequestDispatcher("/jsp/user/update.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
            userService.update(user);
            resp.sendRedirect("/user/list");
    }
}
