package com.smallcode.sample.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
@Component
public class Dog implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public Dog() {
		System.out.println("Dog 构造方法");
	}

	@PostConstruct
	public void init() {
		System.out.println("Dog PostConstruct");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Dog PreDestroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
