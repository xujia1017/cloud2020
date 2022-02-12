package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Nacos: 前四个字母分别是Naming和Configuration的前两个字母，最后的s为service
 *      Nacos就是注册中心+配置中心
 *      Nacos = Eureka + Config + Bus
 *      替代Eureka做服务注册中心，替代Config做服务配置中心
 *
 * Nacos天生自带负载均衡
 *
 * @auther zzyy
 * @create 2020-02-23 17:01
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }

}
