package com.atguigu.springcloud.alibaba.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;

/**
 * @SentinelResource实现限流、降级、熔断
 *      fallback: 管理运行异常对应的降级
 *      blockHandler: 管理配置违规对应的降级
 *
 * @auther zzyy
 * @create 2020-02-25 16:05
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback: 负责运行异常对应的降级
     * blockHandler: 负责sentinel控制台配置违规对应的降级
     */
    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")     //没有配置
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")    //fallback只负责业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")   //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class} //假如报该异常不再有fallback方法兜底,没有降级效果了
    )
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result =
                restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录, 空指针异常");
        }

        return result;
    }

    /**
     * 本例是fallback
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }

    /**
     * 本例是blockHandler
     */
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(),
                payment);
    }

    /**
     * OpenFeign实现服务的调用
     */
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}
