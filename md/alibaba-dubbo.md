## dubbo
1. dubbo 拦截
dubbo 基于类似spi的扩展机制来实现拦截，按照spi的形式显示dubbo的Filter即可。
com.alibaba.dubbo.common.extension.ExtensionLoader 相当于spi的 ServiceLoader
 


