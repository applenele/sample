package com.smallcode.sample.controller;

import com.smallcode.sample.config.MyConfig;
import com.smallcode.sample.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author niele
 * @date 2018/9/29
 */
@RestController
public class HomeController {

	@Autowired
	private MyConfig myConfig;

	@GetMapping(value = "/home/test")
	@ResponseBody
	public User test() {
		User user = new User();
		return user;
	}
}
