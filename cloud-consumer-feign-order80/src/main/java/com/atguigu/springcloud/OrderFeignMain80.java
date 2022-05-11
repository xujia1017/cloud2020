package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 所谓的OpenFeign:
 *      就是客户端服务接口根据@FeignClient注解value值所指向的"微服务名称"去调用服务侧我们暴露对外提供的方法。
 *
 * @auther zzyy
 * @create 2020-02-19 23:57
 */
@SpringBootApplication
@EnableFeignClients     //开启Feign的自动扫描
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }

}
