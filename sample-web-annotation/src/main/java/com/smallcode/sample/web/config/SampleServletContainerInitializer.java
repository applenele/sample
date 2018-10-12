package com.smallcode.sample.web.config;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

import com.smallcode.sample.web.handler.Handler;
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

		ServletRegistration.Dynamic homeServlet = ctx.addServlet("home", HomeServlet.class);
		homeServlet.addMapping("/home");

	}
}
