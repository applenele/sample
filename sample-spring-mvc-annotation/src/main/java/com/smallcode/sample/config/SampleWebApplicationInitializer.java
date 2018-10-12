package com.smallcode.sample.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author niele
 * @date 2018/9/29
 */
public class SampleWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * spring 父容器的配置
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	/**
	 * spring mvc 容器的配置
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // 不能配置为/* 否则找不到视图 ，循环调用dispatcher
	}
}
