package com.smallcode.sample.controller;

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

	@RequestMapping(value = "/home/test", method = RequestMethod.GET)
	//@ResponseBody
	public Object test() {
		return "hello test";
	}
}
