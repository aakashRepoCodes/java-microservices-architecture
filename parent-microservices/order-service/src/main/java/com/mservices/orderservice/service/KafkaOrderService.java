package com.mservices.orderservice.service;

import com.mservices.orderservice.dto.OrderRequest;
import com.mservices.orderservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderService {

    private final KafkaTemplate<String, OrderRequest> kafkaTemplate;

    @Value("${spring.kafka.topic.order-events}")
    String orderTopic;

    public KafkaOrderService(KafkaTemplate<String, OrderRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderRequest orderRequest) {
        kafkaTemplate.send(orderTopic, orderRequest);
    }

}
