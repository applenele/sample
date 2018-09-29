package com.smallcode.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 *
 * @author niele
 * @date 2018/9/29
 */
@ComponentScan(basePackages = "com.smallcode", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
})
public class RootConfig {

}
