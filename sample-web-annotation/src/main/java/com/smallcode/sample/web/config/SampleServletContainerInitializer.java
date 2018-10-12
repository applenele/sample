package com.smallcode.sample.web.config;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

import com.smallcode.sample.web.filter.UserFilter;
import com.smallcode.sample.web.handler.Handler;
import com.smallcode.sample.web.listener.UserListener;
import com.smallcode.sample.web.servlet.HomeServlet;

/**
 *HandlesTypes 订阅感兴趣的类型，servlet容器会帮我们传递进来
 * @author niele
 * @date 2018/9/28
 */
@HandlesTypes({Handler.class})
public class SampleServletContainerInitializer implements ServletContainerInitializer {


	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		// c servlet 容器帮我们注入感兴趣的类型

		ServletRegistration.Dynamic homeServlet = ctx.addServlet("home", HomeServlet.class);
		homeServlet.addMapping("/home");

		// 注册过滤器
		FilterRegistration.Dynamic userFilter = ctx.addFilter("userFilter", UserFilter.class);
		userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

		// 注册监听
		ctx.addListener(UserListener.class);

	}
}
