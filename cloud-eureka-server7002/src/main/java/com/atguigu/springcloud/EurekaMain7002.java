package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 为了解决注册中心的高可用，防止单点故障机群不可用，搭建Eureka注册中心集群，实现负载均衡+故障容错。
 *
 * @auther zzyy
 * @create 2020-02-18 23:44
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }

}
