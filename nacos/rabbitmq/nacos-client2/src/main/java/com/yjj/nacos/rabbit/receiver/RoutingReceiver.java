package com.yjj.nacos.rabbit.receiver;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/6/6 14:44
 */
@Component
public class RoutingReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RoutingReceiver.class);


    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_route_a"), key = "a", exchange = @Exchange(value = "routeExchange", type = "direct")))
    @RabbitHandler
    public void processA(Message message, Channel channel) throws IOException {
        logger.info("rabbitMQ2 收到消息：{}", new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_route_b"), key = "b", exchange = @Exchange(value = "routeExchange", type = "direct")))
    @RabbitHandler
    public void processB(Message message, Channel channel) throws IOException {
        logger.info("rabbitMQ2 收到消息：{}", new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
