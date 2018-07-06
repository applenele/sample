package com.dxy.lenny.sample.boot.support;

import com.dxy.lenny.sample.boot.annotation.RestMapping;
import com.dxy.lenny.sample.boot.consts.Samples;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author niele
 * @date 2018/7/5
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomerRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if (requestMappingInfo != null) {
            return requestMappingInfo;
        }
        return createCustomRequestMappingInfo(method);
    }


    private RequestMappingInfo createCustomRequestMappingInfo(Method method) {
        RestMapping mapping = AnnotatedElementUtils.findMergedAnnotation(method, RestMapping.class);
        if (mapping != null) {
            return RequestMappingInfo.paths(Samples.URI_PREFIX_OF_API + mapping.value())
                    .methods(mapping.method())
                    .build();
        }
        return null;
    }
}
