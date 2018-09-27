package com.smallcode.sample;

import com.smallcode.sample.config.MainConfig;
import com.smallcode.sample.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

		UserService userService = applicationContext.getBean(UserService.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}

//		userService.say();
	}
}
