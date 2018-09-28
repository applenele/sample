package com.smallcode.sample.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
@Component
public class Cat implements InitializingBean,DisposableBean {


	@Override
	public void destroy() throws Exception {
		System.out.println("Cat destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Cat afterPropertiesSet");
	}
}
