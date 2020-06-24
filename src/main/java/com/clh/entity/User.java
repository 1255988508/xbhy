package com.clh.entity;


import java.io.Serializable;

public class User implements Serializable {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String qqOpenid;
  private String wxOpenid;
  private String realName;
  private Long age;
  private String phone;
  private Integer sex;
  private String description;
  private String registerTime;
  private String loginTime;
  private String pic;
  private Long look;
  private String isSecret;
  private String deptName;
  private Long deptId;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQqOpenid() {
    return qqOpenid;
  }

  public void setQqOpenid(String qqOpenid) {
    this.qqOpenid = qqOpenid;
  }

  public String getWxOpenid() {
    return wxOpenid;
  }

  public void setWxOpenid(String wxOpenid) {
    this.wxOpenid = wxOpenid;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(String registerTime) {
    this.registerTime = registerTime;
  }

  public String getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(String loginTime) {
    this.loginTime = loginTime;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public Long getLook() {
    return look;
  }

  public void setLook(Long look) {
    this.look = look;
  }

  public String getIsSecret() {
    return isSecret;
  }

  public void setIsSecret(String isSecret) {
    this.isSecret = isSecret;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }
}
