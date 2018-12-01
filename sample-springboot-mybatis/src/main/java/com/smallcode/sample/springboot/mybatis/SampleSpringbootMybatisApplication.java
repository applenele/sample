package com.smallcode.sample.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smallcode.sample.springboot.mybatis.dao")
public class SampleSpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringbootMybatisApplication.class, args);
	}
}
