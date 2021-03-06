package com.atguigu.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * 手动实现负载均衡算法
 * @auther zzyy
 * @create 2020-02-19 20:33
 */
@Component
public class MyLoadBalencer implements LoadBalancer {

    /**
     * 原子类，保证并发安全
     */
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        // 如果期望值=current，则返回next；
        // 如果期望值!=current,则进入循环逻辑重新取数做判断，直到成功为止
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }

    /**
     * 负载均衡算法：
     *  rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标 ，
     *  每次服务重启动后rest接口计数从1开始。
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
