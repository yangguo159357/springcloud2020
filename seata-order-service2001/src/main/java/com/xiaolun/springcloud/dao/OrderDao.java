package com.xiaolun.springcloud.dao;

import com.xiaolun.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //mybatis中推荐这个使用
public interface OrderDao {
	//新建订单
	void create(Order order);

	//修改订单状态，从零改为1
	void update(@Param("userId") Long userId, @Param("status") Integer status);
}