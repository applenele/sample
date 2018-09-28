package com.smallcode.sample.config;

import com.smallcode.sample.domain.DB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
@ComponentScan(basePackages = {"com.smallcode"})
public class MainConfigOfProfile {

	@Bean("dbTest")
	@Profile("test")
	public DB dbTest() {
		return new DB("test", "123");
	}

	@Bean("dbDev")
	@Profile("dev")
	public DB dbDev() {
		return new DB("dev", "456");
	}
}
