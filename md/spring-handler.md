## spring mvc handler 创建过程
```mermaid
graph TD;
    A[EnableWebMvc]-->B[DelegatingWebMvcConfiguration]
    B-->C[WebMvcConfigurationSupport]
    C-- 创建RequestMappingHandlerMapping -->D[WebMvcConfigurationSupport.requestMappingHandlerMapping]

    C-- 创建RequestMappingHandlerAdapter -->D1[WebMvcConfigurationSupport.requestMappingHandlerAdapter]    

    D-->E[WebMvcConfigurationSupport.createRequestMappingHandlerMapping]
    E-->F[RequestMappingHandlerMapping.afterPropertiesSet]
    F-->G[AbstractHandlerMethodMapping.afterPropertiesSet]
    G-->H[AbstractHandlerMethodMapping.initHandlerMethods]
    H-->J[AbstractHandlerMethodMapping.detectHandlerMethods]
    J-- 调用实现类,获取RequestMappingInfo -->L[RequestMappingHandlerMapping.getMappingForMethod]

    L-- 将RequestMappingInfo和Method映射组合 -->L1[MethodIntrospector.selectMethods]
    L1-- 创建handlerMethod注册到mappingRegistry -->M[AbstractHandlerMethodMapping.registerHandlerMethod]

    L-- 创建RequestMappingInfo -->L2[RequestMappingHandlerMapping.createRequestMappingInfo]
```

## 以@ResponseBody 为例说明 HttpMessageConvert 请求的解析与结果的写入
```mermaid
graph TD;
    A[DispatcherServlet#doDispatch]-->B[AbstractHandlerMethodAdapter#handle]
    B-->C[RequestMappingHandlerAdapter#handleInternal]
    C-->D[RequestMappingHandlerAdapter#invokeHandlerMethod]
    D-->E[ServletInvocableHandlerMethod#invokeAndHandle]
    E-->F[InvocableHandlerMethod#invokeForRequest]
    F--读取请求参数内部适配HttpMessageConvert HandlerMethodArgumentResolver此处用到-->F1[InvocableHandlerMethod#getMethodArgumentValues]
    F1--选择参数处理器-->F1A[argumentResolvers.supportsParameter]
    F1A--处理参数-->F1B[argumentResolvers.resolveArgument]

    F--处理返回参数内部适配HttpMessageConvert-->F2[HandlerMethodReturnValueHandlerComposite#handleReturnValue]
    F2--处理返回值-->F2B[RequestResponseBodyMethodProcessor#handleReturnValue]

    F-- 处理请求 -->F3[InvocableHandlerMethod#doInvoke]
```

## spring mvc messageconvert

- httpmessageconvert 查看
https://www.cnblogs.com/fangjian0423/p/springMVC-xml-json-convert.html


- HandlerMethodReturnValueHandlerComposite 查看
http://www.cnblogs.com/fangjian0423/p/springMVC-request-param-analysis.html

