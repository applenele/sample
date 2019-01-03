package com.lenny.sample.dubbo.common.service;

import com.lenny.sample.dubbo.common.dto.UserDto;

/**
 * @author lenny
 * @Title: UserDubboService
 * @ProjectName sample
 * @date 2019-01-03 11:01
 **/
public interface UserDubboService {

  UserDto getById(Long id);
}
