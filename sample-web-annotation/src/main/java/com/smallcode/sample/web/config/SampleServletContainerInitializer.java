package com.smallcode.sample.web.config;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

import com.smallcode.sample.web.servlet.HomeServlet;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
public class SampleServletContainerInitializer implements ServletContainerInitializer {


	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		ServletRegistration.Dynamic homeServlet = ctx.addServlet("home", HomeServlet.class);
		homeServlet.addMapping("/home");


	}
}
