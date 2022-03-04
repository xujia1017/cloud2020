package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  @SpringbootApplication 注解是一个"三体"结构，重要的只有三个Annotation:
 *     @Configuration : 定义Spring Ioc容器的配置类
 *     @ComponentScan : 自动扫描并加载符合条件的组件或者bean定义
 *     @EnableAutoConfiguration : 让Spring Boot根据类路径下的jar包依赖为当前项目进行自动配置
 *
 *  注:
 *      1   @SpringBootApplication 注解里没有包含 @Configuration注解，实际上是在 @SpringBootConfiguration 里面。@SpringBootConfiguration 注解
 *          继承自 @Configuration，二者功能也一致，标注当前类是配置类，并会将当前类内声明的一个或多个以 @Bean 注解标记的方法的实例纳入到spring容器中，并且实例名就是方法名。
 *
 *      2   @ComponentScan的功能其实就是自动扫描并加载符合条件的组件或bean定义，最终将这些bean定义加载到容器中。
 *          我们可以通过 basePackages 等属性指定 @ComponentScan 自动扫描的范围，如果不指定，则默认Spring框架实现从声明 @ComponentScan 所在类的package进行扫描，默认情况下是不指定的，
 *          所以SpringBoot的启动类最好放在root package下。
 *
 *      3   @EnableAutoConfiguration 可以帮助Springboot应用将所有符合条件的@configuration都加载到当前的SpringBoot创建并使用的Ioc容器。
 *
 *
 * @author Athletic
 * Created on 2022-03-03 17:22:41
 */
@SpringBootApplication  //Spring Boot的主配置类，Spring Boot会运行这个类的main方法来启动Spring Boot应用
@EnableEurekaClient     //服务注册
@EnableDiscoveryClient  //服务发现,对于注册进eureka里面的微服务，可以通过服务发现来获取该服务的信息
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }

}
