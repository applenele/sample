package com.smallcode.sample.springboot.zipkinbrave.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lenny
 * @Title: ZipkinTrace
 * @ProjectName sample
 * @Description: TODO
 * @date 2018-12-0523:26
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZipkinTrace {


  
}
