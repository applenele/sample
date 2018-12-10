
## spring-cloud-sleuth
1. 文档：http://cloud.spring.io/spring-cloud-sleuth/single/spring-cloud-sleuth.html#_custom_sampling

2. 什么spring-cloud-sleuth
底层使用zipkin实现。

## 基于web的追踪

自动一个web端的filter的。TracingFilter通过TraceWebServletAutoConfiguration注册到web容器中。


- brave.http.HttpParser.request

## dubbo zipkin 追踪
brave自定义一个dubbo的filter。
tracing=brave.dubbo.rpc.TracingFilter
在yml文件中配置要使用的filter文件即可