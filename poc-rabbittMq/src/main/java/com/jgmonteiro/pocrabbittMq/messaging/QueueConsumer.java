package com.jgmonteiro.pocrabbittMq.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiver(@Payload final String messagePayload){
        System.out.println("Receive payload: " + messagePayload);
    }
}
