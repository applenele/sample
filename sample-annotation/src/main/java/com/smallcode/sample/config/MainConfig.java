package com.smallcode.sample.config;

import com.smallcode.sample.condition.LinusCondition;
import com.smallcode.sample.condition.WindowsCondition;
import com.smallcode.sample.domain.Car;
import com.smallcode.sample.domain.Color;
import com.smallcode.sample.domain.ColorFactoryBean;
import com.smallcode.sample.domain.User;
import com.smallcode.sample.service.UserService;
import com.smallcode.sample.service.UserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author niele
 * @date 2018/9/27
 */
@ComponentScan(basePackages = "com.smallcode", excludeFilters = {
		//@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
		//@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
})
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//快速导入组件 id为 全类名当在容器的名字,也可以传ImportSelector
public class MainConfig {

	//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	// Scope 调整作用域
	@Bean
	@Lazy // 延迟加载，在ioc容器第一次加载时候初始化实例
	public UserService userService() {
		return new UserServiceImpl();
	}

	/**
	 * 如果系统是windows 获取 bill，如果是linux 获取linus
	 * Conditional 满足 Condition 条件 实例化 给容器注册对象
	 * @return
	 */
	@Bean("bill")
	@Conditional({WindowsCondition.class})
	public User user1() {
		return new User("bill", 12);
	}

	@Bean("linus")
	@Conditional({LinusCondition.class})
	public User user2() {
		return new User("linus", 20);
	}

	// bena 实例化
	// 1.Componet-Scan
	// 2.Bean(导入第三方包)
	// 3. Import
	//    3.1 @Import
	//    3.2 @ImportSelector 返回要往容器注册的类全名的数组
	//    3.3 @ImportBeanDefinitionRegistrar 自己往容器里面注册
	// 4.FactoryBean

	// 获取到的color
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}


	/***
	 * 对象初始化和销毁的时候执行
	 * 1. init，destroy
	 * 2. InitializingBean,DisposableBean
	 * 3. JSR 250 java规范 PostConstruct(bean创建之后，属性赋值之后),PreDestroy（bean 销毁之前）
	 * 4. BeanPostProcessor，postProcessBeforeInitialization 在任何初始化方法之前调用，，postProcessAfterInitialization 在任何销毁方法之后执行
	 */

	/**
	 * 构造方法 > PostConstruct > init > destroy
	 * 单实例的bean 在容器的创建的时候执行init，在容器销毁的额时候执行destroy ，多实例的在getBean的时候执行init，并且多实例的bean容器不执行destroy方法
	 * @return
	 */
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
}

