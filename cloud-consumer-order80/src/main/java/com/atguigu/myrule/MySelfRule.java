package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2020-02-19 19:00
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //定义为随机
        return new RandomRule();
    }

}
