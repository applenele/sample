package com.smallcode.sample.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
public class Car {

	public Car() {
		System.out.println("Car 构造方法执行");
	}

	public void init() {
		System.out.println("Car init 方法  执行");
	}

	public void destroy() {
		System.out.println("Car destroy 方法执行");
	}

	@PostConstruct

	public void post() {
		System.out.println("Car PostConstruct");
	}

}
