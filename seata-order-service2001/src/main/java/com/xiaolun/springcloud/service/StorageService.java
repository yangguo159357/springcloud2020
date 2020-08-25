package com.xiaolun.springcloud.service;

import com.xiaolun.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService { //订单微服务2001去调用库存微服务2002
	@PostMapping(value = "/storage/decrease") //库存做减法（减库存之后数据要进行变更）
	CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}