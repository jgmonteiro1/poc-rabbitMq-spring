package com.jgmonteiro.pocrabbittMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    private final Queue queue;

    public DirectConfig(Queue queue) {
        this.queue = queue;
    }

    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.directExchange("Exchange-A").durable(true).build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue).to(exchange()).with("testeQueue").noargs();
    }
}
