package com.atguigu.springcloud.alibaba.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *  在Spring程序中，Mybatis需要找到对应的mapper，在编译的时候动态生成代理类，实现数据库查询功能，
 *  所以我们需要在接口上添加@Mapper注解。
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
