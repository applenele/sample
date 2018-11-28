package com.smallcode.sample.springboot.jdbc.controller;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lenny
 * @Date: 2018/11/28 23:27
 * @Description:
 */
@RestController
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/articles")
	public Object getArticles() {
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from b_article");
		return maps;
	}
}
