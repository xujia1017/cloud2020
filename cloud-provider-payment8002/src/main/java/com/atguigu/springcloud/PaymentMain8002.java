package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther zzyy
 * @create 2020-02-17 21:13
 */
@SpringBootApplication  //Spring Boot的主配置类，Spring Boot会运行这个类的main方法来启动Spring Boot应用
@EnableEurekaClient     //服务注册
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }

}
