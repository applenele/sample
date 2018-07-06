package com.dxy.lenny.sample.boot.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * @author niele
 * @date 2018/7/5
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestMapping(method = RequestMethod.GET)
public @interface Get {
    @AliasFor(annotation = RestMapping.class)
    int value();
}
