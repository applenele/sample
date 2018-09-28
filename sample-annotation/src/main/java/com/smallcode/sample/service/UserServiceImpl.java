package com.smallcode.sample.service;

import com.smallcode.sample.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
//@Service
public class UserServiceImpl implements UserService {


	@Autowired(required = false) // 没有找到不报错
	@Qualifier("userDao")  // 指定的导入的对象的名称
	private UserDao userDao;

	@Override
	public void say() {
		System.out.println("hi");
	}
}
