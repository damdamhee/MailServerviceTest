package com.test.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceV1 {
    private JavaMailSender javaMailSender;

    public MailServiceV1(@Autowired() JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    public void sendMail(String from, String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }
}
