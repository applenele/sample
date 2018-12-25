## HandlerExceptionResolver

在spring mvc中通过实现HandlerExceptionResolver来处理异常。

可以自定义个异常处理类

```java
@Component // 需要带上此注解
public class MySimpleHandlerExceptionResolverimplements HandlerExceptionResolver,Ordered{
    private static final Logger logger = LoggerFactory.getLogger(MySimpleMappingExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        logger.info("url = {}, exception message = {}", request.getRequestURI(), ex.getMessage());
        // 返回null，让后面HandlerExceptionResolver继续进行处理；如果不让后面的HandlerExceptionResolver进行处理，则这里返回一个ModelAndView对象即可
        return null;
    }
    public int getOrder(){
        // 表示此HandlerExceptionResolver的优先级最高
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

```

最终HandlerExceptionResolver在 org.springframework.web.servlet.DispatcherServlet#doDispatch中的

```java
processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
```

调用。

- 在org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#doResolveHandlerMethodException中。
- 调用org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#getExceptionHandlerMethod 获取在ControllerAdvice写的处理方法



以下是系统默认加载到spring mvc容器中的HandlerExceptionResolver

- ExceptionHandlerExceptionResolver： 根据@ExceptionHandler注解的方法处理对应的异常。其实上文的通过注解的方式处理异常，实际就是在这个类中实现

- ResponseStatusExceptionResolver： 根据@ResponseStatus注解的方法处理异常

- DefaultHandlerExceptionResolver： 将异常转化为特定的HTTP的状态码

- HandlerExceptionResolverComposite：此类通过列表包含以上3个HandlerExceptionResolver，当捕获异常时，会循环调用以上3个HandlerExceptionResolver进行处理


## ControllerAdvice

ControllerAdvice 用户定义处理全局异常的处理方法。例如

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeExJsonException.class)
    public @ResponseBody ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {

       ExceptionJSONInfo response = new ExceptionJSONInfo();
       response.setUrl(request.getRequestURL().toString());
       response.setMessage(ex.getMessage());

       return response;
    }
}
```

这样在在方法上使用@ExceptionHandler注解，spring mvc 在处理错误的时候。ExceptionHandlerExceptionResolver将找到@ExceptionHandler注解的方法，进行处理。

这里handleEmployeeNotFoundException将返回一个json格式的数据。

 @ExceptionHandler注解的方法也可以放回一个页面。



## Controller + ExceptionHandler

在controller上加上ExceptionHandler注解的方法，只会针对该controller的异常处理。



## 参考

https://juejin.im/entry/5a5f3ccff265da3e261bfe61