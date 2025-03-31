package com.example.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue_demo");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchage_demo");
    }

    //Binding between queue and exchange using routing key
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with("routing_key_demo");
    }
}
