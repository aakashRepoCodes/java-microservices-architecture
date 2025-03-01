package com.mservices.notification.notification_service.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Sends a welcome email to the user.
     *
     * @param to Recipient email address
     * @param username Username of the recipient
     * @throws MessagingException if email fails to send
     */
    public void sendWelcomeEmail(String to, String username) throws MessagingException {
        String subject = "Welcome to Our Service!";
        String body = String.format(
                "<h1>Welcome, %s!</h1><p>We are thrilled to have you with us. " +
                        "Explore and enjoy our services!</p>", username);

        sendEmail(to, subject, body);
    }

    /**
     * Sends an order confirmation email to the user.
     *
     * @param to Recipient email address
     * @param orderId Order ID for the confirmation
     * @throws MessagingException if email fails to send
     */
    public void sendOrderConfirmationEmail(String to, String orderId) throws MessagingException {
        String subject = "Your Order Has Been Placed!";
        String body = String.format(
                "<h1>Thank you for your order!</h1><p>Your order with ID <b>%s</b> " +
                        "has been placed successfully. We will notify you once it is shipped.</p>", orderId);

        sendEmail(to, subject, body);
    }

    /**
     * Generic method to send an email.
     *
     * @param to Recipient email address
     * @param subject Email subject
     * @param body Email body (supports HTML)
     * @throws MessagingException if email fails to send
     */
    private void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(message);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
