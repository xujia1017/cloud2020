package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @MapperScan
 * 作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 * 添加位置：是在Springboot启动类上面添加，
 *
 * 添加 @MapperScan(“com.atguigu.springcloud.alibaba.dao”)注解以后，
 * com.atguigu.springcloud.alibaba.dao包下面的接口类，在编译之后都会生成相应的实现类
 *
 * 早些的时间是直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，比较麻烦。
 * 现在通过使用@MapperScan可以指定要扫描的Mapper类的包的路径，批量的生成对应的类。
 *
 * @auther zzyy
 * @create 2019-12-11 16:57
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
