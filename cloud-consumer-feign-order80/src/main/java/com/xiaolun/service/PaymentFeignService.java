package com.xiaolun.service;

import com.xiaolun.springcloud.entities.CommonResult;
import com.xiaolun.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

	//延时方法
	@GetMapping(value = "/payment/feign/timeout")
	public String paymentFeignTimeout();
}
