package com.xiaolun.springcloud.service.Impl;

import cn.hutool.core.lang.UUID;
import com.xiaolun.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import javax.annotation.Resource;

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider
{
	@Resource
	private MessageChannel output; // 消息发送管道

	@Override
	public String send()
	{
		String serial = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(serial).build()); //构建消息
		System.out.println("*****serial: "+serial);
		return null;
	}
}
