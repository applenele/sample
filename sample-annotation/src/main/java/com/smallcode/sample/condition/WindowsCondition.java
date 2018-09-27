package com.smallcode.sample.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Environment environment = context.getEnvironment();

		String property = environment.getProperty("os.name");

		if (property.contains("Windows")) {
			return true;
		}

		return false;
	}
}
