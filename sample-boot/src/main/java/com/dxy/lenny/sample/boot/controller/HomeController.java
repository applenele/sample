package com.dxy.lenny.sample.boot.controller;

import com.dxy.lenny.sample.boot.annotation.Get;
import com.dxy.lenny.sample.boot.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niele
 * @date 2018/7/5
 */
@RestController
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @Get(value = 12345678)
    public Object get() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "test")
    public String test() {
        return "test";
    }
}
