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
 * @date: 2019/6/6 9:16
 */
@Component
public class FanoutReceiver {

    private static final Logger logger= LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_fanout_a"),exchange = @Exchange(value = "fanoutExchange",type = "fanout")))
    @RabbitHandler
    public void process1(Message message, Channel channel) throws IOException, InterruptedException {
        logger.info("receiverA tag:{}", message.getMessageProperties().getDeliveryTag());
//        Thread.sleep(5000);
        //手动确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        logger.info("rabbitMQA 收到消息：{}", new String(message.getBody()));
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_fanout_b"),exchange = @Exchange(value = "fanoutExchange",type = "fanout")))
    @RabbitHandler
    public void process2(Message message, Channel channel) throws IOException, InterruptedException {
        logger.info("receiverB tag:{}", message.getMessageProperties().getDeliveryTag());
//        Thread.sleep(5000);
        //手动确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        logger.info("rabbitMQB 收到消息：{}", new String(message.getBody()));
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_fanout_c"),exchange = @Exchange(value = "fanoutExchange",type = "fanout")))
    @RabbitHandler
    public void process3(Message message, Channel channel) throws IOException, InterruptedException {
        logger.info("receiverC tag:{}", message.getMessageProperties().getDeliveryTag());
//        Thread.sleep(5000);
        //手动确认
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        logger.info("rabbitMQC 收到消息：{}", new String(message.getBody()));
    }
}
