package com.example.rabbitmq.publisher;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RabbitMQProducer {


    RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        log.info("Message sent -> {}", message);
        rabbitTemplate.convertAndSend("exchange_demo", "routing_key_demo", message);
    }
}
