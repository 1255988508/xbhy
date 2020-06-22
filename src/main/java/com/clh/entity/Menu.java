package com.clh.entity;

/**
 * @auth chenlh
 * @data 2020/6/22 12:31
 * @Description
 */
public class Menu {
    private Integer id;
    private Integer p_Id;
    private String type;
    private String name;
    private String url;
    private String orderBy;

    public Menu() {
    }

    public Menu(Integer id, Integer p_Id, String type, String name, String url, String orderBy) {
        this.id = id;
        this.p_Id = p_Id;
        this.type = type;
        this.name = name;
        this.url = url;
        this.orderBy = orderBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return p_Id;
    }

    public void setpId(Integer pId) {
        this.p_Id = pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
