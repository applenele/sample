#### 1.Autowire （Spring的注解）

- 构造器（一个有参构造器可以省略Autowire），参数，方法，字段 都能注解
- 方法位置 @Bean + 参数（参数从容器里面自动注入 详细查看MainConfig，参数可以默认不写Autowired）
- 在容器里面多个装配对象的时候，按照Autowire 字段名称去容器里面去查找
- 在容器里面多个装配对象的时候，@Qualifier("name") 指定名字
- 在容器里面多个装配对象的时候，@Primary 指定优先级查找

#### spring 还支持@Resource(JSR250) 和@Inject(JSR330) （Java 的规范）

- @Resource 可以跟Autowire一样使用，按照字段名称来注入，没有支持@Primary和@Autowire(require=false)
- @Inject 需要导入依赖 （javax.inject） 和@Autowire 功能一样


#### 自定义的组件调用spring底层组件（XXXXWare）
- 直接实现XXXWare,容器自动注入XXX
- EmbeddedValueResolverAware,解析占位符

#### profile 环境表示
- 使某一类生效 
- 