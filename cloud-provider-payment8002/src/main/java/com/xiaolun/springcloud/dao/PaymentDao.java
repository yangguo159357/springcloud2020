package com.xiaolun.springcloud.dao;

import com.xiaolun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //推荐使用
public interface PaymentDao {
    int create(Payment payment); //写操作，新增
    Payment getPaymentById(@Param("id") Long id); //读操作
}
