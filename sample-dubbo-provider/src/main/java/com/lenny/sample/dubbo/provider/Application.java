package com.lenny.sample.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lenny
 * @Title: Application
 * @ProjectName sample
 * @date 2019-01-03 11:03
 **/
@SpringBootApplication
@EnableDubbo
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
