package com.orderify.paymentservice.messaging;

import com.orderify.paymentservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.orderify.paymentservice.config.RabbitMQConfig;

@Component
public class OrderProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, order);
    }
}