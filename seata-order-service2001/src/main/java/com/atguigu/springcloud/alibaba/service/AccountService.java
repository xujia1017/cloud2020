package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springcloud.alibaba.domain.CommonResult;

/**
 * 远程调用`账户服务`进行余额扣减
 *
 * @auther zzyy
 * @create 2020-02-26 15:22
 */
@FeignClient(value = "seata-account-service")   //远程调用名为'seata-account-service'的微服务的'/account/decrease'接口
public interface AccountService {

    /**
     * 扣减账户余额
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
