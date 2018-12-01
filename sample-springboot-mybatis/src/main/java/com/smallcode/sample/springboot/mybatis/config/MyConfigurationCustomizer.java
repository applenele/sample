package com.smallcode.sample.springboot.mybatis.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

/**
 * @Auther: lenny
 * @Date: 2018/12/2 00:07
 * @Description:
 */
@org.springframework.context.annotation.Configuration
public class MyConfigurationCustomizer implements ConfigurationCustomizer {

	@Override
	public void customize(Configuration configuration) {
		configuration.setMapUnderscoreToCamelCase(true);
	}
}
