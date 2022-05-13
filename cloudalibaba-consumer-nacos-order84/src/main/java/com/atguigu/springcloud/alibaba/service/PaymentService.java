package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * 所谓的OpenFeign，就是客户端服务接口根据 @FeignClient 注解 value 值所指向的`微服务名称`去调用服务侧我们暴露对外提供的方法
 *
 * 使用 fallback 方式是无法获取异常信息的，如果想要获取异常信息，可以使用 fallbackFactory 参数
 *
 * @auther zzyy
 * @create 2020-02-25 18:15
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
