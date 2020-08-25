package com.xiaolun.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaolun.springcloud.entities.CommonResult;
import com.xiaolun.springcloud.entities.Payment;
import com.xiaolun.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "handleException")
//	@SentinelResource(value = "byResource")
	public CommonResult byResource() {
		return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
	}

	public CommonResult handleException(BlockException exception) {
		return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
	}

	@GetMapping("/rateLimit/byUrl")
	@SentinelResource(value = "byUrl")
	public CommonResult byUrl() {
		return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
	}

	/**
	 * 采用指定的类进行处理Sentinel,此时
	 * blockHandlerClass：指定处理的类
	 * blockHandler：指定处理的方法
	 */
	@GetMapping("/rateLimit/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler",
			blockHandlerClass = CustomerBlockHandler.class,
			blockHandler = "handlerException")
	public CommonResult customerBlockHandler() {
		return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
	}

}