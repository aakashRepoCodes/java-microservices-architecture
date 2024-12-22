package com.mservices.notification.notification_service.service;

import com.mservices.orderservice.event.SimpleOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;


@Service
@Slf4j
public class NotificationService {

    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.order-events}", groupId = "notification-service")
    public void consumeOrderEvent(SimpleOrder orderPlaced) {
        try {
            System.out.println("Received message: " + orderPlaced.getOrderId());
            emailService.sendOrderConfirmationEmail("aakashchaturvedi7@gmail.com", orderPlaced.getOrderId());
        } catch (Exception e) {
            throw new RuntimeException("Error processing message: " + orderPlaced.getOrderId(), e);
        }
    }

}
