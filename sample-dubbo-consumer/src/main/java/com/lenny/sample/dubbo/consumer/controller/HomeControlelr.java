package com.lenny.sample.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lenny.sample.dubbo.common.dto.UserDto;
import com.lenny.sample.dubbo.common.service.UserDubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenny
 * @Title: HomeControlelr
 * @ProjectName sample
 * @date 2019-01-03 11:29
 **/
@RestController
public class HomeControlelr {

  @Reference(version = "1.0.0")
  private UserDubboService userDubboService;

  @GetMapping("/user/{id}")
  public UserDto get(@PathVariable("id") Long id) {
    return userDubboService.getById(id);
  }
}
