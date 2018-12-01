package com.smallcode.sample.springboot.mybatis.controller;

import java.util.List;

import com.smallcode.sample.springboot.mybatis.dao.ArticleMapper;
import com.smallcode.sample.springboot.mybatis.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lenny
 * @Date: 2018/12/1 23:28
 * @Description:
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleMapper articleMapper;

	@GetMapping
	public List<Article> getAll() {
		return articleMapper.getAll();
	}
}
