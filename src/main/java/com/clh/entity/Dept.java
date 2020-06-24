package com.clh.entity;

import sun.rmi.server.InactiveGroupException;

import java.io.Serializable;

/**
 * @auth chenlh
 * @data 2020/6/23 16:46
 * @Description
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
