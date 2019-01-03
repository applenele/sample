package com.lenny.sample.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lenny
 * @Title: ConsumerApplication
 * @ProjectName sample
 * @date 2019-01-03 11:26
 **/
@SpringBootApplication
@EnableDubbo
public class ConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }
}
