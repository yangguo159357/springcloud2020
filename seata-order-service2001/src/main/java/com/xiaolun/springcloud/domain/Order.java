package com.xiaolun.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;

	private Long userId;

	private Long productId;

	private Integer count; //库存

	private BigDecimal money;

	private Integer status; //订单状态（初始状态永远为0）：0：创建中；1：已完结
}
