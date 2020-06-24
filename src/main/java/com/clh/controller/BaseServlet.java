package com.clh.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auth chenlh
 * @data 2020/6/22 18:29
 * @Description
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] uriArr=uri.split("/");
        String method=uriArr[uriArr.length-1];
        Class clazz=this.getClass();
        try {
            Method useMethod=clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            useMethod.setAccessible(true);
            useMethod.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
