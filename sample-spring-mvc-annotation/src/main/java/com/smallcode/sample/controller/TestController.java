package com.smallcode.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author niele
 * @date 2018/9/29
 */
@Controller
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
