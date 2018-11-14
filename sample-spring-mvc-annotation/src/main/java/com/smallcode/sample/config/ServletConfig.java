package com.smallcode.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  取代 servlet-mvc.xml
 * @author niele
 * @date 2018/9/29
 */
@ComponentScan(basePackages = "com.smallcode", includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
}, useDefaultFilters = false)
@EnableWebMvc // 开启spring mvc的配置功能，类似 annotation-driven
public class ServletConfig  extends WebMvcConfigurerAdapter {


//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/views/",".jsp");
//		super.configureViewResolvers(registry);
//	}
}
