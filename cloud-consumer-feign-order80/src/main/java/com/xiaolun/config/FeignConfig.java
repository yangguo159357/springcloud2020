package com.xiaolun.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel(){
		//代表自己开启的是一个详细日志
		return Logger.Level.FULL;
	}
}
