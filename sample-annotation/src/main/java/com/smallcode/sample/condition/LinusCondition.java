package com.smallcode.sample.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *  判断条件
 * @author niele
 * @date 2018/9/27
 */
public class LinusCondition implements Condition {


	/**
	 *
	 * @param context 用于条件判断的上下文
	 * @param metadata
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

		Environment environment = context.getEnvironment();

		String property = environment.getProperty("os.name");

		if (property.contains("linux")) {
			return true;
		}


		return false;
	}
}
