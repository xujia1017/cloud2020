package com.atguigu.springcloud.controller;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;

import lombok.extern.slf4j.Slf4j;

/**
 * 服务消费中，通过Eureka注册中心获取支付服务，然后向支付服务发起请求
 *
 * @auther zzyy
 * @create 2020-02-18 17:23
 */
@RestController
@Slf4j
public class OrderController {

    //单机版注册中心
    //public static final String PAYMENT_URL = "http://localhost:8001";

    //集群版注册中心-配置为微服务的名称，而不再关心地址和端口号
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";



    /**
     * RestTemplate 就是Spring封装的处理同步HTTP请求的类。它提供了常见用于访问Rest服务的 客户端模板工具集。
     *
     *  使用restTemplate访问restful接口非常的简单粗暴无脑。
     *  (url, requestMap, ResponseBean.class)这三个参数分别代表: REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     *
     *
     * @Resource:
     *      默认按照名称进行装配，名称可以通过name属性进行指定，如果没有指定name属性，当注解写在字段上时，默认取字段名进行安装名称查找，
     *      如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。
     *      但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。这个注解属于J2EE的。
     *
     * @Autowired:
     *      默认按类型装配, 默认情况下必须要求依赖对象必须存在, 如果要允许null值, 可以设置它的required属性为false, 如：@Autowired(required=false),
     *      这个注解是属于spring的，如果我们想使用名称装配可以结合 @Qualifier 注解进行使用。
     */
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(400, "操作失败");
        }
    }

    /**
     * 根据自定义负载均衡算法，路由到服务注册中得到的服务地址
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLb() {
        //从服务注册中心获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //根据自定义的负载均衡算法得到路由的服务
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        //根据得到的服务地址去远程请求payment服务
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

    /**
     * 服务监控追踪:zipkin+sleuth
     */
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
    }
}
