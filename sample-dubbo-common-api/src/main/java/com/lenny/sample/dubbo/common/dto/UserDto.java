package com.lenny.sample.dubbo.common.dto;

import java.io.Serializable;

/**
 * @author lenny
 * @Title: UserDto
 * @ProjectName sample
 * @date 2019-01-03 11:01
 **/
public class UserDto implements Serializable {

  private Long id;

  private String username;

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
}
