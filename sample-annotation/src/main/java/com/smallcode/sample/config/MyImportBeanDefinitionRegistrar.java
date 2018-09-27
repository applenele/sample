package com.smallcode.sample.config;

import com.smallcode.sample.domain.RainBow;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 *
	 * @param importingClassMetadata  当前类的注解信息
	 * @param registry BeanDefinition 注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean red = registry.containsBeanDefinition("com.smallcode.sample.domain.Blue");
		if (red) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
	}
}
