package com.smallcode.sample;

import java.util.Map;

import com.smallcode.sample.config.MainConfig;
import com.smallcode.sample.domain.User;
import com.smallcode.sample.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
public class App {


	static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);


	public static void main(String[] args) {

		applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);


		Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");

		System.out.println(colorFactoryBean.getClass());

		//Object rainBow = applicationContext.getBean("rainBow");


		//test1();

		//test2();
	}

	public static void test2() {

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		// 获取操作系统
		System.out.println(environment.getProperty("os.name"));

//		Map<String, Object> systemProperties = environment.getSystemProperties();
//		for (Map.Entry<String, Object> entry : systemProperties.entrySet()) {
//
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}

		String[] beanNames = applicationContext.getBeanNamesForType(User.class);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		System.out.println("=====================================");

		Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);

		for (Map.Entry<String, User> entry : beansOfType.entrySet()) {
			System.out.println(entry.getValue());
		}
	}


	public static void test1() {

		UserService userService = applicationContext.getBean(UserService.class);
		UserService userService1 = applicationContext.getBean(UserService.class);

		System.out.println(userService == userService1);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}

		userService.say();
	}
}
