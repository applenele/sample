package com.smallcode.sample.sample.springboot.cache.redis.controller;

import com.smallcode.sample.sample.springboot.cache.redis.dao.ArticleMapper;
import com.smallcode.sample.sample.springboot.cache.redis.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

  @Autowired
  private ArticleMapper articleMapper;


  @GetMapping("/{id}")
  public Article get(@PathVariable(name = "id") Integer id) {
    return articleMapper.getById(id);
  }
}
