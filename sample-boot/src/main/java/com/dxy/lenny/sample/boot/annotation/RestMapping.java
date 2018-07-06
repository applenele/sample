package com.dxy.lenny.sample.boot.annotation;

import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author niele
 * @date 2018/7/5
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestMapping {

    int value() default 0;

    RequestMethod method();
}
