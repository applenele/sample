package com.dxy.lenny.sample.boot;

import com.alibaba.druid.pool.DruidDataSource;
import com.dxy.lenny.sample.boot.config.DbProperty;
import com.dxy.lenny.sample.boot.support.CustomerRequestMappingHandlerMapping;
import com.dxy.lenny.sample.boot.support.SampleViewTemplateResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Jpa 必须跟Application文件相同的地方，或者到层的上面，否则找不到dao层
 *
 * @author niele
 * @date 2018/7/5
 */
@ComponentScan
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary"
)
@EnableTransactionManagement(proxyTargetClass = true)//启用cglib代理
public class SampleConfiguration {

    /**
     * 自定义请求映射
     *
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping customRequestMappingHandlerMapping() {
        CustomerRequestMappingHandlerMapping mappingHandlerMapping = new CustomerRequestMappingHandlerMapping();
        mappingHandlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return mappingHandlerMapping;
    }

    @Autowired
    private DbProperty dbProperty;

    @Bean(name = "entityManagerPrimary")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Bean(name = "primaryDS")
    @Qualifier("primaryDS")
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbProperty.getUrl());
        dataSource.setUsername(dbProperty.getUsername());
        dataSource.setPassword(dbProperty.getPassword());
        dataSource.setDriverClassName(dbProperty.getDriverClassName());
        return dataSource;
    }

    @Bean(name = "entityManagerFactoryPrimary")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return buildEntityManagerFactory(primaryDataSource(), null);

    }

    protected LocalContainerEntityManagerFactoryBean buildEntityManagerFactory(DataSource dataSource, Class<?> clazz) {
        return buildEntityManagerFactory(dataSource, clazz, false);
    }

    protected LocalContainerEntityManagerFactoryBean buildEntityManagerFactory(DataSource dataSource, Class<?> clazz, boolean showSql) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSql);
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.dxy.lenny.sample");

        return factoryBean;
    }


    @Bean(name = "transactionManagerPrimary")
    @Primary
    PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }


//    @Bean
//    @Description("Thymeleaf template resolver serving HTML 5")
//    public ClassLoaderTemplateResolver templateResolver() {
//
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//
//        //templateResolver.setPrefix("static/");
//        templateResolver.setCacheable(false);
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCharacterEncoding("UTF-8");
//
//        return templateResolver;
//    }

    @Bean
    public SampleViewTemplateResolver templateResolver() {
        return new SampleViewTemplateResolver();
    }

//
//    @Bean
//    @Description("Thymeleaf template engine with Spring integration")
//    public SpringTemplateEngine templateEngine() {
//
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//
//        return templateEngine;
//    }
//
//    @Bean
//    @Description("Thymeleaf view resolver")
//    public ViewResolver viewResolver() {
//
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//
//        return viewResolver;
//    }
}
