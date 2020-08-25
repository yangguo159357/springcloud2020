package com.xiaolun.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.xiaolun.springcloud.dao"})
public class MyBatisConfig {
}