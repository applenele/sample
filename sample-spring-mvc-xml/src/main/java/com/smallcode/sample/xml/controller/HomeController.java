package com.smallcode.sample.xml.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


  @ResponseBody
  @GetMapping("/home/index")
  public String index() {
    return "index";
  }
}
