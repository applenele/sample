package com.smallcode.sample.config;

import com.smallcode.sample.service.UserService;
import com.smallcode.sample.service.UserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
@ComponentScan(basePackages = "com.smallcode", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
@Configuration
public class MainConfig {

//	@Bean
//	public UserService userService() {
//		return new UserServiceImpl();
//	}
}
