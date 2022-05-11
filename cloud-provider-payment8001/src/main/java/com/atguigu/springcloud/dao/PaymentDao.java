package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.entities.Payment;

/**
 *  @Mapper 是 Mybatis 的注解，和 Spring 没有关系;
 *  @Repository 是 Spring 的注解，用于声明一个 Bean。
 *
 *  在Spring程序中，Mybatis需要找到对应的mapper，在编译的时候动态生成代理类，实现数据库查询功能，所以我们需要在接口上添加@Mapper注解。
 *  @Repository 用于声明 dao 层的 bean。
 *
 *
 * @auther zzyy
 * @create 2020-02-18 10:27
 */
@Mapper //推荐使用该注解，不推荐使用@reposity
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
