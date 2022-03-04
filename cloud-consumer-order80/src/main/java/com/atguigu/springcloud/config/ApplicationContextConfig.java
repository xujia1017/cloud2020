package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 通过注解配置类获取RestTemlate的实现类对象
 *
 *
 *  @Configuration:
 *      标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 *
 *  @Bean:
 *      标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象。默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域。
 *      既然@Bean的作用是注册bean对象，那么完全可以使用@Component、@Controller、@Service、@Ripository等注解注册bean，当然需要配置 @ComponentScan 注解进行自动扫描。
 *
 *
 *  注: @Configuration 用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被 @Bean 注解的方法，这些方法将会被
 *      AnnotationConfigApplicationContext 或 AnnotationConfigWebApplicationContext 类进行扫描，并用于构建bean定义，初始化Spring容器。
 *
 *
 * @auther zzyy
 * @create 2020-02-18 17:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
//applicationContext.xml <bean id="" class="">