package com.jgmonteiro.pocrabbittMq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue configQueue() {
        return QueueBuilder.durable("testeQueue").build();
    }
}
