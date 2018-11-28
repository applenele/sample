package com.smallcode.sample.springboot.jdbc.config;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lenny
 * @Date: 2018/11/28 23:06
 * @Description: 配置druid
 */
@Configuration
public class DruidConfig {

	/**
	 * 配置数据源
	 * @return
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	/**
	 * 1、配置一个管理后台的servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

		Map<String, String> initMap = new HashMap<>();
		initMap.put("loginUsername", "root");
		initMap.put("loginPassword", "root");
		initMap.put("allow", "127.0.0.1");

		servletRegistrationBean.setInitParameters(initMap);

		return servletRegistrationBean;
	}

	/***
	 * 2.配置web监控的filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());

		Map<String, String> initMap = new HashMap<>();
		// 过滤一些跟数据库查询无关的
		initMap.put("exclusions", "*.js,*.css,/druid/*");
		filterRegistrationBean.setInitParameters(initMap);

		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegistrationBean;
	}

}
