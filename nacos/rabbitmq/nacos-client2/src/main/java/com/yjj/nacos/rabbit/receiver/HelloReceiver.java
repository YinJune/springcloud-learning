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
public class HelloReceiver {
    private static final Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

    @RabbitListener(queues = "q_hello")
    @RabbitHandler
    public void process(Message message, Channel channel) throws IOException, InterruptedException {
        try {
//        Thread.sleep(20000);
            String string=null;
            string.toString();
            //手动确认 false为只确认当前consumer一个消息收到，true为确认所有consumer消息收到
            logger.info("rabbitMQ 收到消息：{}", new String(message.getBody()));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            //是否是重发的消息
            if (message.getMessageProperties().getRedelivered()){
                logger.info("消息重复处理失败，拒绝再次接收：{}",new String(message.getBody()));
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            }else {
                logger.info("消息处理失败，即将再次返回队列：{}",new String(message.getBody()));
                //第一个false为是当前consumer还是所有，第二个为是否重新入队
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            }
        }
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("q_topic_message"),key = "topic.message",exchange = @Exchange(value = "testexchange",type = "topic")))
    @RabbitHandler
    public void processQTopicMessage(Message message, Channel channel) throws IOException {
        logger.info("rabbitMQ 收到消息：{}", new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
