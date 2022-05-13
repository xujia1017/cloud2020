package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * 自定义限流处理类，来实现自定义的限流处理逻辑，而不是用Sentinel自带的默认限流处理信息
 *
 * @auther zzyy
 * @create 2020-02-25 15:32
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义, global handlerException ---- 1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义, global handlerException ---- 2");
    }

}
