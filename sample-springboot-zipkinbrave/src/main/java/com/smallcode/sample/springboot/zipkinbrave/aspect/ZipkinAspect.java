package com.smallcode.sample.springboot.zipkinbrave.aspect;

import brave.ScopedSpan;
import brave.Tracer;
import brave.sampler.BoundarySampler;
import brave.sampler.DeclarativeSampler;
import brave.sampler.Sampler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lenny
 * @Title: ZipkinAspect
 * @ProjectName sample
 * @Description: TODO
 * @date 2018-12-0523:25
 **/
@Component
//@Aspect
public class ZipkinAspect {


  @Value("${spring.application.name}")
  private String appName;


  @Autowired
  private Tracer tracer;

  private ScopedSpan startNewSpan(String serviceName, String methodSignature) {
    // Span name contains class and method name
    final StringBuilder spanNameBuilder = new StringBuilder("/").append(methodSignature);

    final ScopedSpan span = tracer.startScopedSpan(spanNameBuilder.toString());
    if (span != null) {
      span.tag("peer.service", serviceName);
    }

    return span;
  }

  private void addErrorDetailsToSpan(ScopedSpan span, Throwable throwable) {
    if (span == null) {
      return;
    }

    span.error(throwable);
  }

  private void closeSpan(ScopedSpan span) {
    if (span == null) {
      return;
    }

    span.finish();
  }

  @Around("@annotation(com.smallcode.sample.springboot.zipkinbrave.annotation.ZipkinTrace)")
  public Object traceAllMethodCalls(ProceedingJoinPoint pJoinPoint) throws Throwable {
    final MethodSignature methodSignature = (MethodSignature) pJoinPoint.getSignature();

    // We add local-ops after service name to signify that these spans are for internal method calls
    final String serviceName = appName + "-" + "local-ops";

    final String targetMethodSignature = methodSignature.toShortString();
    final ScopedSpan span = startNewSpan(serviceName, targetMethodSignature);
    try {
      return pJoinPoint.proceed();
    } catch (Exception exception) {
      addErrorDetailsToSpan(span, exception);
      throw exception;
    } finally {
      closeSpan(span);
    }
  }

}
