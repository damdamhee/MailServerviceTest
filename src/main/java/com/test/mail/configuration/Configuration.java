package com.test.mail.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Value("${spring.mail.username}")
    public String username;
    @Value("${spring.mail.password}")
    public String password;
    @Value("${spring.mail.host}")
    public String host;
    @Value("${spring.mail.port}")
    public int port;
    @Value("${spring.mail.protocol}")
    public String protocol;
    @Value("${spring.mail.default-encoding}")
    public String encoding;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    public String auth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    public String tlsEnabled;
    @Value("${spring.mail.debug}")
    public String debug;

    @Bean
    public JavaMailSender getJavaMailSender(){
        System.out.println("@Configuration - javaMailSender");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.host);
        mailSender.setPort(this.port);
        mailSender.setUsername(this.username);
        mailSender.setPassword(this.password);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", this.protocol);
        properties.put("mail.smtp.auth", this.auth);
        properties.put("mail.smtp.starttls.enable", this.tlsEnabled);
        properties.put("mail.debug", this.debug);

        return mailSender;
    }
}
