package com.dxy.lenny.annotation;

/**
 * @Auther: lenny
 * @Date: 2018/11/23 02:07
 * @Description:
 */
public class TestController {

	@GetMapping(name = "/index")
	public String index() {
		return "index";
	}
}
