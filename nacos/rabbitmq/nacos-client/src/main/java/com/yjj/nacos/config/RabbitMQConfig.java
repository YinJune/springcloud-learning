//package com.yjj.nacos.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @description:
// * @author: Yin JunJie
// * @date: 2019/6/4 16:57
// */
//@Configuration
//public class RabbitMQConfig {
//
//    final static String message = "q_topic_message";
//    final static String messages = "q_topic_messages";
//
//    @Bean
//    public Queue queue(){
//        return new Queue("q_hello");
//    }
//
//    @Bean
//    public Queue queueMessage(){
//        return new Queue(message);
//    }
//
//    @Bean
//    public Queue queueMessages(){
//        return new Queue(messages);
//    }
//
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange("testexchange");
//    }
//
//    @Bean
//    public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange){
//        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
//    }
//    @Bean
//    public Binding bindingExchangeMessages(Queue queueMessages,TopicExchange topicExchange){
//        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
//    }
//}
