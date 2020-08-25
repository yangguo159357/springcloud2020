package com.xiaolun.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaolun.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
	public static CommonResult handlerException(BlockException exception) {
		return new CommonResult(4444, "自定义限流处理信息....CustomerBlockHandler");

	}
}