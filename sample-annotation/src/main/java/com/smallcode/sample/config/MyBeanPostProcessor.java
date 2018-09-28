package com.smallcode.sample.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPost 使用场景很多：
 * 1.Aware
 * 2.@PostConstrcut
 * 3.Autowire
 * @author niele
 * @date 2018/9/28
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


	/**
	 *
	 * @param bean 刚创建的实例
	 * @param beanName 实例在容器里面的名字
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + ":postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
