package com.dxy.lenny.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * @Auther: lenny
 * @Date: 2018/11/23 02:06
 * @Description:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = "GET")
public @interface GetMapping {

	@AliasFor(annotation = RequestMapping.class, attribute = "name")
	String name() default "";
}
