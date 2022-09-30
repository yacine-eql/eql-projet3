package com.eql.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yacine.saib@gmail.com");
        message.setTo("forteen3@gmail.com");
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }


    public void sendSimpleEmailByCom(String email,
            String subject,
            String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yacine.saib@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }

}
