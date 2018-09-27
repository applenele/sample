package com.smallcode.sample.domain;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		return true ;
	}
}
