
## spring-cloud-sleuth
1. 文档：http://cloud.spring.io/spring-cloud-sleuth/single/spring-cloud-sleuth.html#_custom_sampling

2. 什么spring-cloud-sleuth
底层使用zipkin实现。

## 几个关键类

- TraceWebServletAutoConfiguration:基于web的配置 注入TracingFilter
- brave.http.HttpParser.request