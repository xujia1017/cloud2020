package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Nacos天生一出来就自带负载均衡，理由是Nacos内部整合继承了Ribbon，整合了Ribbon就可以用Resttemplate，那么下面就是标配的模板代码
 *
 * @auther zzyy
 * @create 2020-02-25 16:06
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //加了该注解，按照微服务名找到微服务时，可以根据算法负载均衡得找到对应的实例去请求
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
