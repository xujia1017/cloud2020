package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



/**
 * 服务治理:
 *      在传统的rpc远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理，
 *      管理服务于服务之间依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。
 *
 * 服务注册与发现:
 *      在服务注册与发现中，有一个注册中心。
 *      当服务器启动的时候，会把当前自己服务器的信息 比如 服务地址通讯地址等以别名方式注册到注册中心上。
 *      另一方（消费者 | 服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地 RPC 调用。
 *      RPC 远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系 ( 服务治理概念 ) 。
 *      在任何 rpc 远程框架中，都会有一个注册中心 ( 存放服务地址相关信息 ( 接口地址 ))。
 *
 * Eureka:
 *      采用了 client-server 的设计架构，包含两个组件: Eureka Server 和 Eureka Client。Eureka Server作为服务注册功能的服务器，它是服务注册中心。
 *      而系统中的其他微服务，使用 Eureka Client连接到 Eureka Server 并维持心跳连接。这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。
 *
 *      Eureka Server: 提供服务注册服务
 *          各个微服务节点通过配置启动后，会在Eureka Server中进行注册，这样Eureka Server中的服务注册表中将会存储所有可用服务节点的信息，
 *          服务节点的信息可以在界面中直观看到。
 *
 *      Eureka Client: 通过注册中心进行访问
 *          是一个Java客户端，用于简化与Eureka Server的交互，客户端同时也具备一个内置的、使用轮询(round-robin)负载算法的负载均衡器。
 *          在应用启动后，将会向Eureka Server发送心跳(默认周期为30秒)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，
 *          EurekaServer将会从服务注册表中把这个服务节点移除（默认90秒）。
 *
 * Eureka的自我保护模式:
 *      默认情况下，如果Eureka Server在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。
 *      但是当网络分区故障发生(延时、卡顿、拥挤)时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，
 *      此时本不应该注销这个微服务 。
 *      Eureka通过“自我保护模式”来解决这个问题——当Eureka Server节点在短时间内丢失过多客户端时（可能发生了网络分区故障），
 *      那么这个节点就会进入自我保护模式。
 *
 *      在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何服务实例。
 *
 *
 * Eureka Server端: 服务注册中心
 *
 *
 * @auther zzyy
 * @create 2020-02-18 21:15
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }

}
