package com.mservices.notification.notification_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "order-events", groupId = "notification-service")
    public void consumeMessage(String message){

        log.info("Received Order Event: {}", message);

    }

}
