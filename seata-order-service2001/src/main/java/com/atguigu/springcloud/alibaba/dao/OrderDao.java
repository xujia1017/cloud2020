package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * 在Spring程序中，Mybatis需要找到对应的mapper，在编译的时候动态生成代理类，实现数据库查询功能，
 * 所以我们需要在接口上添加@Mapper注解。
 *
 * @auther zzyy
 * @create 2020-02-26 15:17
 */
@Mapper
public interface OrderDao {

    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);

}