package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    @Value("spring.mail.username")
    private String senderUsername;

    private final JavaMailSender mailSender;

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String mailTo, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(mailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(senderUsername);

        mailSender.send(mailMessage);

        logger.info("Mail verification to" + mailTo + " was sent");
    }
}
