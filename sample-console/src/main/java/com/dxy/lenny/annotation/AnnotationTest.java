package com.dxy.lenny.annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @Auther: lenny
 * @Date: 2018/11/23 02:07
 * @Description:
 */
public class AnnotationTest {

	public static void main(String[] args) {
		Class<TestController> testControllerClass = TestController.class;
		Method[] methods = testControllerClass.getMethods();
		for (Method method : methods) {
			//RequestMapping annotation = AnnotationUtils.findAnnotation(method.getClass(), RequestMapping.class);
			RequestMapping annotation = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
			System.out.println(annotation.getClass());
		}
	}
}
