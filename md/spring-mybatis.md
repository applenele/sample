## mybatis 集成到spring的思路

#### spring自身包注册的流程是

A类->BeanDefinition->A对象

#### spring,mybatis的注册流程

Mapper接口->BeanDefinition(class=MapperFactoryBean)->MapperFactoryBean类对象
->MapperFactoryBean.getObject()获取mapper的代理对象