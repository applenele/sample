package com.smallcode.sample.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public void say() {
		System.out.println("hi");
	}
}
