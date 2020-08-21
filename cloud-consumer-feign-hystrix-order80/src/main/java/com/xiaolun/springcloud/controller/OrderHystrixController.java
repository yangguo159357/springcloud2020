package com.xiaolun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaolun.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j //全局兜底方法
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {
	@Resource
	private PaymentHystrixService paymentHystrixService;
	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_OK(id);
		log.info("*******result:" + result);
		return result;
	}

	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	@HystrixCommand
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		int res = 10 / 0; //测试服务降级用例
		String result = paymentHystrixService.paymentInfo_TimeOut(id);
		return result;
	}

	//自定义的兜底方法
	public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
		return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
	}

	//全局配置
	public String payment_global_fallbackMethod() {
		return "Global处理异常信息，请稍后重试";
	}
}