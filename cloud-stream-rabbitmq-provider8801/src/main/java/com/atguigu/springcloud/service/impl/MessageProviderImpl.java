package com.atguigu.springcloud.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.atguigu.springcloud.service.IMessageProvider;

/**
 * 定义消息生产者的的推送管道
 *
 * @auther zzyy
 * @create 2020-02-22 10:56
 */
@EnableBinding(Source.class)    //可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " + serial);
        return null;
    }

}
