package com.dxy.lenny.model;

/**
 * @author lenny
 * @Title: User
 * @ProjectName sample
 * @Description: TODO
 * @date 2018-12-27 17:12
 **/
public class User {

  private Long id;

  private String username;

  private String password;

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
}
