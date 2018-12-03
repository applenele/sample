package com.smallcode.sample;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lenny
 * @Date: 2018/12/2 17:42
 * @Description: 自定义一个AutoConfiguration
 */
@Configuration
@EnableConfigurationProperties(DataProperties.class)
public class DataAutoConfiguration {

	@Bean
	public DataService dataService() {
		return new DataService();
	}
}

