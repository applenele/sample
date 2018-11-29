## spring boot 嵌入式容器

> 本文以嵌入式tomcat为例

### 启动嵌入式容器的流程
```mermaid
graph TD;
    A[SpringApplication.run]--进过一些步骤-->B[SpringApplication#ruu]
    B --> C[SpringApplication#refreshContext]
    C--> D[EmbeddedWebApplicationContext#onRefresh]
    D--> E[createEmbeddedServletContainer]
    E--先得到containerFactory,在去获取container-->F[containerFactory.getEmbeddedServletContainer]

    F--创建tomcat并启动tomcat线路-->F1[getTomcatEmbeddedServletContainer创建tomcat传入该方法]
    F1-->F1A[TomcatEmbeddedServletContainer构造函数]
    F1A-->F1B[initialize方法]
    F1B--启动tomcat-->F1C[this.tomcat.start]

    F-- ServletContextInitializer处理线 -- 创建toncat -->F2[prepareContext]
    F2--TomcatStarter创建,传入ServletContextInitializer代理-->F2A[configureContext]

    F -- 获取ServletContextInitializer对象--> F3[EmbeddedWebApplicationContext#getSelfInitializer]
    F3-->F3A[ServletContextInitializer代理#onStartup]
    F3A-->F3B[EmbeddedWebApplicationContext#selfInitialize#selfInitialize]
    F3B--获取全部的ServletContextInitializer-->F3C[getServletContextInitializerBeans]
    F3C-- 每个ServletContextInitializer.onStartup-->F3D[onStartup]
```

```java
// 创建容器的核心代码，此处主要做了三件事，见流程图
//org.springframework.boot.context.embedded.EmbeddedWebApplicationContext#createEmbeddedServletContainer
private void createEmbeddedServletContainer() {
    EmbeddedServletContainer localContainer = this.embeddedServletContainer;
    ServletContext localServletContext = getServletContext();
    if (localContainer == null && localServletContext == null) {
        // 嵌入式容器工厂创建
        EmbeddedServletContainerFactory containerFactory = getEmbeddedServletContainerFactory();
        // 根据工厂创建容器 此处实例化一个ServletContextInitializer传入
        this.embeddedServletContainer = containerFactory
                .getEmbeddedServletContainer(getSelfInitializer());
    }
    else if (localServletContext != null) {
        try {
            getSelfInitializer().onStartup(localServletContext);
        }
        catch (ServletException ex) {
            throw new ApplicationContextException("Cannot initialize servlet context",
                    ex);
        }
    }
    initPropertySources();
}
```

### ServletContainerInitializer :
1. TomcatServer包含ServletContextInitializer，TomcatServer创建的时候传入了ServletContextInitializer一个对象。该对象代理全部的ServletContextInitializer，暂且称之为代理对象
2. TomcatServer实现ServletContainerInitializer,在创建的时候赋值给容器
3. 容器启动时调用TomcatServer，TomcatServer调用ServletContextInitializer对象，代理对象调用全部的ServletContextInitializer对象

### ServletContainerInitializer应用
1. ServletRegistrationBean:在spring boot项目中添加servlet
2. FilterRegistrationBean:在spring boot项目中添加过滤器
3. ServletRegistrationBean，spring boot中注入DispatcherServlet（DispatcherServletAutoConfiguration）


