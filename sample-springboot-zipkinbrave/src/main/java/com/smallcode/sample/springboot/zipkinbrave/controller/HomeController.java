package com.smallcode.sample.springboot.zipkinbrave.controller;

import com.smallcode.sample.springboot.zipkinbrave.annotation.ZipkinTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenny
 * @Title: HomeController
 * @ProjectName sample
 * @Description: TODO
 * @date 2018-12-0516:25
 **/
@RestController
public class HomeController {


  @GetMapping("/home/index")
  @ZipkinTrace
  public String index() {
    return "index";
  }
}
