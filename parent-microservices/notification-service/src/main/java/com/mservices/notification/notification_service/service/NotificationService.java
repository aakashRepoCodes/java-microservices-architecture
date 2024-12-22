package com.mservices.notification.notification_service.service;

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

    @KafkaListener(topics = "order-events", groupId = "notification-service")
    public void consumeMessage(String message){
        try {
            System.out.println("Received message: " + message);
            emailService.sendOrderConfirmationEmail("aakashchaturvedi7@gmail.com", "12");
        } catch (Exception e) {
            throw new RuntimeException("Error processing message: " + message, e);
        }
    }

}
