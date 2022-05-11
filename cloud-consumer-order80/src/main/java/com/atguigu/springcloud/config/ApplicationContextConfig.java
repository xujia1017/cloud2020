package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 通过注解配置类获取RestTemlate的实现类对象
 *
 *  @Configuration:
 *      这个注解加在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 *
 *  @Bean:
 *      这个注解类似于bean xml配置文件中的bean元素，用来在spring容器中注册一个bean。
 *      该注解作用在方法上，表示通过方法来定义一个bean，默认将方法名称作为bean名称，将方法返回值作为bean对象，注册到spring容器中。。
 *      默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域。
 *      既然@Bean的作用是注册bean对象，那么完全可以使用@Component、@Controller、@Service、@Ripository等注解注册bean，
 *      当然需要配置 @ComponentScan 注解进行自动扫描。
 *
 *  1   不管@Bean所在的类上是否有@Configuration注解，都可以将@Bean修饰的方法作为一个bean注册到spring容器中
 *  2   @Configuration注解修饰的类，spring容器中会通过cglib给这个类创建一个代理，代理会拦截所有被 @Bean 修饰的方法，
 *      默认情况（bean为单例）下确保这些方法只被调用一次，从而确保这些bean是同一个bean，即单例的。
 *      如果类没有被@Configuration注解修饰，只有@Bean，那么就不会有cglib代理，就不能确保底层依赖注入的对象是单例的。
 *
 *  注: @Configuration 用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被 @Bean 注解的方法，这些方法将会被
 *      AnnotationConfigApplicationContext 或 AnnotationConfigWebApplicationContext 类进行扫描，并用于构建bean定义，初始化Spring容器。
 *
 * @auther zzyy
 * @create 2020-02-18 17:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate具有了客户端负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
//applicationContext.xml <bean id="" class="">