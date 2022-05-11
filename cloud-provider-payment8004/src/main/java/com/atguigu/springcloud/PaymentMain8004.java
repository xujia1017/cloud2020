package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Zookeeper服务器取代Eureka服务器，Zookeeper作为服务注册中心
 *
 * @auther zzyy
 * @create 2020-02-19 14:15
 */
@SpringBootApplication
@EnableDiscoveryClient  //服务发现,对于注册进Eureka、Consul、Zookeeper里面的微服务,可以通过服务发现来获取该服务的信息
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }

}
