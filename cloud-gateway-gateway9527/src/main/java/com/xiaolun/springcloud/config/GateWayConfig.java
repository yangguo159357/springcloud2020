package com.xiaolun.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
	/**
	 * 1、配置了一个id为 path_rote_xiaolun 的路由规则
	 * 当访问地址http://localhost:9527/guonei时会
	 * 自动转发地址到：http://www.baidu.com/guonei
	 */
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
		routes.route("path_rote_xiaolun",
				r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
		return routes.build();
	}
}
