package com.mservices.orderservice.service;

import com.example.kafka.Order;
import com.example.kafka.SimpleOrder;
import com.mservices.orderservice.dto.OrderPlaced;
import com.mservices.orderservice.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.order-events}")
    private String topic;

    public KafkaOrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(String orderId) {
        kafkaTemplate.send(topic, orderId);
        System.out.println("Sent Order ID: " + orderId);
    }
}
