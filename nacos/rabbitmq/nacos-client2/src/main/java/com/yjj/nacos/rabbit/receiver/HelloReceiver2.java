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
 * @date: 2019/6/4 17:00
 */
@Component
public class HelloReceiver2 {
    private static final Logger logger = LoggerFactory.getLogger(HelloReceiver2.class);

    @RabbitListener(queuesToDeclare = @Queue("q_hello"))
    @RabbitHandler
    public void process(Message message, Channel channel) throws IOException, InterruptedException {
        if (message.getMessageProperties().getRedelivered()){
            logger.info("重新入队的消息");
        }
        //手动确认
        logger.info("rabbitMQ2 收到消息：{}", new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_topic_messages"), key = "topic.#", exchange = @Exchange(value = "testexchange", type = "topic")))
    @RabbitHandler
    public void processQTopicMessage(Message message, Channel channel) throws IOException {
        logger.info("rabbitMQ2 收到消息：{}", new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
