package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 分布式事务-账户服务
 *
 * @auther zzyy
 * @create 2019-12-13 21:59
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient  //能够让注册中心(Nacos)发现，扫描到该服务
@EnableFeignClients     //OpenFeign远程调用
public class SeataAccountMainApp2003 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }

}
