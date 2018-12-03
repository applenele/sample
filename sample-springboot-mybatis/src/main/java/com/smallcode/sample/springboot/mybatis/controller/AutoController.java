package com.smallcode.sample.springboot.mybatis.controller;

import com.smallcode.sample.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lenny
 * @Date: 2018/12/2 18:02
 * @Description:
 */
@RestController
public class AutoController {

	@Autowired
	private DataService dataService;

	@GetMapping("/auto/show")
	public String show() {
		dataService.show();
		return "show";
	}
}
