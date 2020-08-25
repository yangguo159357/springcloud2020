package com.xiaolun.springcloud.service.impl;

import com.xiaolun.springcloud.entities.CommonResult;
import com.xiaolun.springcloud.entities.Payment;
import com.xiaolun.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
	@Override
	public CommonResult<Payment> paymentSQL(Long id)
	{
		return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
	}
}
