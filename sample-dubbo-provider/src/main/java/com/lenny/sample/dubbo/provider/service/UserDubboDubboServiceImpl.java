package com.lenny.sample.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lenny.sample.dubbo.common.dto.UserDto;
import com.lenny.sample.dubbo.common.service.UserDubboService;

/**
 * @author lenny
 * @Title: UserDubboDubboServiceImpl
 * @ProjectName sample
 * @date 2019-01-03 11:03
 **/
@Service(version = "1.0.0")
public class UserDubboDubboServiceImpl implements UserDubboService {

  @Override
  public UserDto getById(Long id) {
    UserDto userDto = new UserDto();
    userDto.setId(id);
    userDto.setUsername("张三");
    return userDto;
  }
}
