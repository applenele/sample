## spring aop
1. 核心处理类：ProxyFactory
2. 两个方面：通知和切点
- 通知（Advice）：对切点的操作。
  - MethodBeforeAdvice :方法之前处理
  - AfterReturningAdvice：返回之前
  - MethodInterceptor ： AOP联盟定义的接口，用于环绕
- 切点（Pointcut）: 用于拦截、代理的点，通过Pointcut找到连接点（找到要拦截或者代理的方法）

3. JoinPoint 
连接点。程序运行中的一些时间点, 例如一个方法的执行, 或者是一个异常的处理.就是要出处理的方法。

4. spring 中 JoinPoint
通过切点拦截点的方法，再通过Advice进行植入（Weaving），组织成新的了；连接点。
例如:CglibMethodInvocation


5. PointcutAdvisor 
包含Advice和Pointcut


https://segmentfault.com/a/1190000015319623#articleHeader4
http://cxis.me/2017/04/12/Spring%E4%B8%ADAOP%E6%BA%90%E7%A0%81%E6%B7%B1%E5%85%A5%E8%A7%A3%E6%9E%90/