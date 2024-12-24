package com.mservices.orderservice.service;

import com.mservices.orderservice.event.SimpleOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderService {
    private final KafkaTemplate<String, SimpleOrder> kafkaTemplate;

    @Value("${spring.kafka.topic.order-events}")
    private String topic;

    public KafkaOrderService(KafkaTemplate<String, SimpleOrder> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(SimpleOrder simpleOrder) {
        kafkaTemplate.send(topic, simpleOrder);
        System.out.println("Sent Order ID: " + simpleOrder.getOrderId());
    }
}
