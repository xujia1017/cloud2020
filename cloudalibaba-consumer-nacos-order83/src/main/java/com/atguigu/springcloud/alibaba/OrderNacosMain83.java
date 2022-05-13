package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud Alibaba Nacos: 服务注册中心 + 服务配置中心 + Bus总线(实现动态刷新)
 *
 * @auther zzyy
 * @create 2020-02-23 14:44
 */
@EnableDiscoveryClient  //自带ribbon，支持负载均衡
@SpringBootApplication
public class OrderNacosMain83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class, args);
    }

}
