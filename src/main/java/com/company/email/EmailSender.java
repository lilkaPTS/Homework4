package com.company.email;

import com.company.model.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


public class EmailSender {

    public static void sentEmail(User user) {
        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
        emailSender.setHost("smtp.gmail.com");
        emailSender.setPort(587);

        emailSender.setUsername("lilspringboothw4@gmail.com");
        emailSender.setPassword("springboothw4");

        Properties props = emailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Simple Email");
        message.setText("Hello," + user.getFirstName() + " " + user.getPatronymic() + " have a good day!");

        emailSender.send(message);
    }
}
