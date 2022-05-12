package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Config客户端实现动态刷新
 *
 * @RefreshScope注解能实现动态刷新，作用是实时将应用中环境变量的变化同步到已实例化的bean对象中。
 * @RefreshScope注解的作用是：可以使当前已经实例化的实例对象中的属性值随着配置文件的更新而动态更新。
 *
 * Spring Boot Actuator 模块提供了生产级别的功能，比如健康检查，审计，指标收集，HTTP跟踪等，帮助我们监控和管理SpringBoot应用。
 * 这个模块是一个采集应用内部信息暴露给外部的模块，上述的功能都可以通过HTTP和JMX访问。
 *
 * 此方法仅限于服务端更新后，客户端重新请求才能生效，不能实现服务端更新后，进行大范围广播所有客户端来使所有客户端生效。
 *
 *
 * @auther zzyy
 * @create 2020-02-21 18:08
 */
@RestController
@RefreshScope   //实现客户端动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
