package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCloud Config配置中心模块-分布式配置中心的服务端
 *
 * @auther zzyy
 * @create 2020-02-21 17:47
 */
@SpringBootApplication
@EnableConfigServer         //开启Config Server
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }

}
