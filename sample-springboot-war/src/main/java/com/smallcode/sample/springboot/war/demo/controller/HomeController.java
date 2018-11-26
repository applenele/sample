package com.smallcode.sample.springboot.war.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lenny
 * @Date: 2018/11/26 23:58
 * @Description:
 */
@RestController
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
