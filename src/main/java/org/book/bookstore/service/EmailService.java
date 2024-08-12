package org.book.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("humbet.alizade13@gmail.com");
        message.setFrom("humbet.alizade04@gmail.com");
        message.setSubject("Test the email-service");
        message.setText("Did you get the message?");
        javaMailSender.send(message);
    }
}
