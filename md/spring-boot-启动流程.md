## SpringApplication 启动流程

先看下核心代码

#### SpringApplication初始化
```java
public SpringApplication(ResourceLoader resourceLoader, Object... sources) {
    this.resourceLoader = resourceLoader;
    initialize(sources);
}

@SuppressWarnings({ "unchecked", "rawtypes" })
private void initialize(Object[] sources) {
    if (sources != null && sources.length > 0) {
        this.sources.addAll(Arrays.asList(sources));
    }
    // 判断是不是web环境
    this.webEnvironment = deduceWebEnvironment();

    // 获取所有的ApplicationContextInitializer，赋值给initializers
    setInitializers((Collection) getSpringFactoriesInstances(
            ApplicationContextInitializer.class));
    
    // 获取全部的ApplicationListener，赋值给listeners
    setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));

    // 设置启动类
    this.mainApplicationClass = deduceMainApplicationClass();
}
```
#### SpringApplication执行run方法
org.springframework.boot.SpringApplication#run(java.lang.String...)
```java
public ConfigurableApplicationContext run(String... args) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    ConfigurableApplicationContext context = null;
    FailureAnalyzers analyzers = null;
    configureHeadlessProperty();
    SpringApplicationRunListeners listeners = getRunListeners(args);
    listeners.starting();
    try {
        ApplicationArguments applicationArguments = new DefaultApplicationArguments(
                args);
        ConfigurableEnvironment environment = prepareEnvironment(listeners,
                applicationArguments);
        Banner printedBanner = printBanner(environment);
        context = createApplicationContext();
        analyzers = new FailureAnalyzers(context);
        prepareContext(context, environment, listeners, applicationArguments,
                printedBanner);
        refreshContext(context);
        afterRefresh(context, applicationArguments);
        listeners.finished(context, null);
        stopWatch.stop();
        if (this.logStartupInfo) {
            new StartupInfoLogger(this.mainApplicationClass)
                    .logStarted(getApplicationLog(), stopWatch);
        }
        return context;
    }
    catch (Throwable ex) {
        handleRunFailure(context, listeners, analyzers, ex);
        throw new IllegalStateException(ex);
    }
}
```



### 启动时候几个组件
1. ApplicationContextInitializer：启动的springboot项目的时候，可以通过该组件初始化 ApplicationContext一些东西，比如像容器中加一些监听器。
2. EventPublishingRunListener： 监听Springboot在启动时候各个事件，委托给ApplicationListener事件处理。SpringApplication的监听者，ApplicationListener事件发布者
3. ApplicationListener：监听EventPublishingRunListener发布的事件。
4. ApplicationRunner：容器ApplicationContext， afterRefresh之后执行
5. CommandLineRunner：容器ApplicationContext， afterRefresh之后执行


```mermaid
graph TD;
    A[SpringApplication]-->B[SpringApplication构造方法]
    B--构造方法内部-->C[SpringApplication#initialize]
    C--以下是initialize做的事情-->C1[this.sources设置source]
    C1-->C2[判断是不是web环境]
    C2-->C3[获取全部的ApplicationContextInitializer赋值给SpringApplication]
    C3-->C4[获取全部的ApplicationListener赋值给SpringApplication]
    C4-->C5[设置启动类]

    B--执行初始化之后执行-->D[SpringApplication#run]
    D--设置headless模式-->D1[configureHeadlessProperty]
    D1--获取全部的SpringApplicationRunListeners-->D2[getRunListeners]
    D2-->D3[printBanner]
    D3--创建ApplicationContext-->D4[createApplicationContext]
    D4--ApplicationContext准备-->D5[prepareContext]
    
    D5--prepareContext内内部方法--执行ApplicationContextInitializer的initialize-->D5A[SpringApplication#applyInitializers]
    D5A--装载启动类-->D5B[SpringApplication#load]

    D5--refreshContext-->D6[refreshContext]
    D6--在refresh之后调用-->D7[afterRefresh]

    D6--refreshContext内部方法-->D6A[AbstractApplicationContext#refresh]
    D6A-->D6B[EmbeddedWebApplicationContext#onRefresh]
    D6B--创建嵌入式servlet容器-->D6C[createEmbeddedServletContainer]

    D7--从容器中获取runner执行runner-->D8[callRunners,ApplicationRunner,CommandLineRunner]
```

